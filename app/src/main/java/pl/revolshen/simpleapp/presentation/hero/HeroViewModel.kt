package pl.revolshen.simpleapp.presentation.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.revolshen.simpleapp.data.network.NetworkMonitor
import pl.revolshen.simpleapp.domain.usecases.GetHeroUseCase
import pl.revolshen.simpleapp.presentation.components.HeroUiEffect

//@HiltViewModel
class HeroViewModel(
    private val getHero: GetHeroUseCase,
    networkMonitor: NetworkMonitor,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(HeroUiState())

    val uiState = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<HeroUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        observeNetwork(networkMonitor)
    }

    fun observeNetwork(networkMonitor: NetworkMonitor) {
        viewModelScope.launch {
            networkMonitor.isOnline.collect { isOnline ->

                val previousState=_uiState.value.isOnline

                _uiState.update {
                    it.copy(isOnline = isOnline)
                }

                if (previousState != isOnline) {
                    _effect.emit(
                        HeroUiEffect.ShowSnackbar(
                            if (isOnline) {
                                "Connect enable"
                            } else {
                                "No Internet connection"
                            }
                        )
                    )
                }
            }
        }
    }

    fun onHeroIdChanged(value: String) {
        if (value.all { it.isDigit() } || value.isEmpty()) {
            _uiState.update {
                it.copy(heroId = value)
            }
        }
    }

    fun loadHero() {
        if (!_uiState.value.isOnline) { return }

        val id = _uiState.value.heroId.toIntOrNull()
            ?: return

        viewModelScope.launch {

            _uiState.update {
                it.copy(isLoading = true)
            }

            runCatching {
                getHero(id)
            }.onSuccess { hero ->
                _uiState.update {
                    it.copy(
                        hero = hero,
                        isLoading = false
                    )
                }
            }.onFailure {

                _uiState.update {
                    it.copy(isLoading = false)
                }

                _effect.emit(
                    HeroUiEffect.ShowSnackbar("Error while fetching data")
                )
            }
        }
    }
}

/*
class CharacterViewModel(
    private val getCharacter: GetCharacterUseCase,
    networkMonitor: NetworkMonitor,
    private val repository: CharacterRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            networkMonitor.isOnline.collect { connected ->
                _uiState.update {
                    it.copy(isOnline = connected)
                }
            }
        }
    }

    fun onCharacterIdChanged(value: String) {
        _uiState.update {
            it.copy(characterId = value)
        }
    }

    fun loadCharacter() {
        val id = _uiState.value.characterId.toIntOrNull()
            ?: return

        viewModelScope.launch {

            _uiState.update {
                it.copy(loading = true)
            }

            runCatching {
                repository.getCharacter(id)
            }.onSuccess { character ->

                _uiState.update {
                    it.copy(
                        character = character,
                        loading = false
                    )
                }
            }.onFailure {
                _uiState.update {
                    it.copy(loading = false)
                }
            }
        }
    }
}*/
