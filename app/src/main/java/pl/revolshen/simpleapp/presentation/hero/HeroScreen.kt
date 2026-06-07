package pl.revolshen.simpleapp.presentation.character

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.revolshen.simpleapp.di.ServiceLocator
import pl.revolshen.simpleapp.presentation.hero.HeroContent
import pl.revolshen.simpleapp.presentation.hero.HeroViewModel

@Composable
fun HeroScreen() {
    val viewModel: HeroViewModel =
        viewModel(factory = ServiceLocator.provideHeroViewModelFactory())

    HeroContent(viewModel = viewModel)
}