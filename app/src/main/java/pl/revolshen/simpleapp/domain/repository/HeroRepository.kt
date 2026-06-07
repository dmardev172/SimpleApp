package pl.revolshen.simpleapp.domain.repository

import pl.revolshen.simpleapp.domain.models.Hero

interface HeroRepository {

    suspend fun getHero(id: Int): Hero
}