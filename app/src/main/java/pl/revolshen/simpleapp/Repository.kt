package pl.revolshen.simpleapp

/*import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import pl.revolshen.simpleapp.data.local.HeroDb
import pl.revolshen.simpleapp.data.models.SerialHero
import pl.revolshen.simpleapp.data.remote.RemoteSource
import retrofit2.Response

class Repository(context: Context) {

    private val dao = HeroDb.getInstance(context).heroDao()
    private val api = RemoteSource.api

    fun getHero(id: Int): Flow<SerialHero> {
        return dao.getHero(id)
    }

    suspend fun loadHero(id: Int): Response<SerialHero> {
        return api.getHero(id)
    }

    suspend fun insertAll(list: List<SerialHero>) = withContext(Dispatchers.IO) {
        dao.insert(list)
    }
}*/
