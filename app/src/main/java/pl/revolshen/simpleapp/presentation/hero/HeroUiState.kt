package pl.revolshen.simpleapp.presentation.hero

//import pl.revolshen.simpleapp.data.models.SerialHero
import pl.revolshen.simpleapp.domain.models.Hero

data class HeroUiState(
    val heroId: String = "",
    val isOnline: Boolean = true,
    val isLoading: Boolean = false,
    val hero: Hero? = null, //SerialHero?
)
