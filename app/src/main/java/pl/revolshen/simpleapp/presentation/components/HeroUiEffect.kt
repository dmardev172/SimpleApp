package pl.revolshen.simpleapp.presentation.components

sealed interface HeroUiEffect {

    data class ShowSnackbar(val message: String) : HeroUiEffect
}