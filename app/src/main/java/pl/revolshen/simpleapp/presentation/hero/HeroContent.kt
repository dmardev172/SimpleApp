package pl.revolshen.simpleapp.presentation.hero

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.revolshen.simpleapp.presentation.components.HeroCard
import pl.revolshen.simpleapp.presentation.components.HeroInput
import pl.revolshen.simpleapp.presentation.components.HeroUiEffect
import pl.revolshen.simpleapp.presentation.components.LoadingIndicator

@Composable
fun HeroContent(viewModel: HeroViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HeroUiEffect.ShowSnackbar -> {
                    //possible Snackbar text: "No internet connection"
                    snackbarHostState.showSnackbar(message = effect.message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HeroInput(
                value = uiState.heroId,
                isOnline = uiState.isOnline,
                onValueChange = viewModel::onHeroIdChanged,
                onSearchClick = viewModel::loadHero
            )

            if (uiState.isLoading) {
                LoadingIndicator()
            }

            uiState.hero?.let {
                HeroCard(hero = it)
            }
        }
    }
}