package pl.revolshen.simpleapp.presentation.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.revolshen.simpleapp.data.network.NetworkMonitor
import pl.revolshen.simpleapp.domain.usecases.GetHeroUseCase

class HeroViewModelFactory(
    private val getHeroUseCase: GetHeroUseCase,
    private val networkMonitor: NetworkMonitor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroViewModel::class.java)) {
            return HeroViewModel(
                getHero = getHeroUseCase,
                networkMonitor = networkMonitor
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}