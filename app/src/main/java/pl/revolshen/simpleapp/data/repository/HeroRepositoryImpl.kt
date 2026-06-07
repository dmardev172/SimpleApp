package pl.revolshen.simpleapp.data.repository

import pl.revolshen.simpleapp.data.mapper.toDomain
import pl.revolshen.simpleapp.data.remote.HeroApi
import pl.revolshen.simpleapp.domain.models.Hero
import pl.revolshen.simpleapp.domain.repository.HeroRepository

class HeroRepositoryImpl(private val api: HeroApi) : HeroRepository {

    override suspend fun getHero(id: Int): Hero {
        return api.getHero(id).toDomain()
    }
}