package pl.revolshen.simpleapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import pl.revolshen.simpleapp.data.local.CharacterDb
import pl.revolshen.simpleapp.data.models.SerialCharacter
import pl.revolshen.simpleapp.data.remote.RemoteSource
import retrofit2.Response

class Repository(context: Context) {

    private val dao = CharacterDb.getInstance(context).characterDao()
    private val api = RemoteSource.api

    fun getCharacter(id: Int): Flow<SerialCharacter> {
        return dao.getCharacter(id)
    }

    suspend fun loadCharacter(id: Int): Response<SerialCharacter> {
        return api.getCharacter(id)
    }

    suspend fun insertAll(list: List<SerialCharacter>) = withContext(Dispatchers.IO) {
        dao.insert(list)
    }
}

