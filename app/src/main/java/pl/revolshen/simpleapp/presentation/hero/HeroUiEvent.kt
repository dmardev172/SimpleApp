package pl.revolshen.simpleapp.presentation.hero

sealed interface HeroUiEvent {

    data class IdChanged(val value: String) : HeroUiEvent

    data object LoadHero
}