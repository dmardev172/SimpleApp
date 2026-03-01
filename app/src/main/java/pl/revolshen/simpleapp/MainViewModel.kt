package pl.revolshen.simpleapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.revolshen.simpleapp.data.models.SerialCharacter

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = Repository(application)

    private val _character = MutableStateFlow<SerialCharacter?>(null) //sealed class instead
    //    val character = _character.asStateFlow()
    val character: StateFlow<SerialCharacter?> = _character.asStateFlow()

    fun performFetchSingleCharacter(id: Int) = viewModelScope.launch {
        val local = repo.getCharacter(id).first()

        if (local != null) {
            Log.d("PROCESS_D", "Local source")
            _character.update { local }
            return@launch
        }

        val remote = repo.loadCharacter(id)

        if (remote.isSuccessful) {
            Log.d("PROCESS_D", "Remote source")
            val data = remote.body()

            if (data != null) {
                _character.update { data }
                repo.insertAll(listOf(data))
            }
        }
    }
}