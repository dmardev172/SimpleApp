package pl.revolshen.simpleapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import pl.revolshen.simpleapp.data.network.NetworkMonitor
import pl.revolshen.simpleapp.data.network.NetworkMonitorImpl
import pl.revolshen.simpleapp.data.remote.HeroApi
import pl.revolshen.simpleapp.data.remote.RetrofitFactory
import pl.revolshen.simpleapp.data.repository.HeroRepositoryImpl
import pl.revolshen.simpleapp.domain.usecases.GetHeroUseCase
import pl.revolshen.simpleapp.presentation.hero.HeroViewModelFactory

object ServiceLocator {

    private var initialized = false
    private lateinit var networkMonitor: NetworkMonitor

    // Retrofit
    private val retrofit by lazy { RetrofitFactory.create() }

    // HeroApi
    private val api by lazy { retrofit.create(HeroApi::class.java) }

    // Repository
    private val repository by lazy { HeroRepositoryImpl(api) }

    // UseCase
    val getHeroUseCase by lazy { GetHeroUseCase(repository) }

    // NetworkMonitor
    fun initialize(context: Context) {
        if (initialized) return

        networkMonitor = NetworkMonitorImpl(context.applicationContext)
        initialized = true
    }

    // ViewModelFactory
    fun provideHeroViewModelFactory(): ViewModelProvider.Factory {
        return HeroViewModelFactory(
            getHeroUseCase = getHeroUseCase,
            networkMonitor = networkMonitor
        )
    }
}