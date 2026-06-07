package pl.revolshen.simpleapp.data.remote

import pl.revolshen.simpleapp.data.models.SerialHero
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {

    /*@GET("character/{id}")
    suspend fun getHero(@Path("id") id: Int): Response<SerialHero>*/

    @GET("character/{id}")
    suspend fun getHero(@Path("id") id: Int): SerialHero
}

object RemoteSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(HeroApi::class.java)
}