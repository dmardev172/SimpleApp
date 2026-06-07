package pl.revolshen.simpleapp.domain.usecases

import pl.revolshen.simpleapp.domain.models.Hero
import pl.revolshen.simpleapp.domain.repository.HeroRepository

class GetHeroUseCase(private val repository: HeroRepository) {

    suspend operator fun invoke(id: Int): Hero {
        return repository.getHero(id)
    }
}