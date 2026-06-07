package pl.revolshen.simpleapp

/*
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
import pl.revolshen.simpleapp.data.models.SerialHero

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = Repository(application)

    private val _hero = MutableStateFlow<SerialHero?>(null) //sealed class instead
    //    val hero = _hero.asStateFlow()
    val hero: StateFlow<SerialHero?> = _hero.asStateFlow()

    fun performFetchSingleHero(id: Int) = viewModelScope.launch {
        val local = repo.getHero(id).first()

        if (local != null) {
            Log.d("PROCESS_D", "Local source")
            _hero.update { local }
            return@launch
        }

        val remote = repo.loadHero(id)

        if (remote.isSuccessful) {
            Log.d("PROCESS_D", "Remote source")
            val data = remote.body()

            if (data != null) {
                _hero.update { data }
                repo.insertAll(listOf(data))
            }
        }
    }
}*/
