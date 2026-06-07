Application uses https://rickandmortyapi.com/api/

```text
ServiceLocator
        │
        ├── Retrofit
        ├── CharacterApi
        ├── Repository
        ├── UseCase
        ├── NetworkMonitor
        └── ViewModelFactory
```
```text
app
│
├── data
│   ├── remote
│   │   ├── HeroApi.kt
│   │   └── RetrofitFactory.kt
│   │
│   ├── models
│   │   ├── SerialHero.kt
│   │   └── HeroResponse.kt
│   │
│   ├── mapper
│   │   └── HeroMapper.kt
│   │
│   ├── network
│   │   ├── NetworkMonitor.kt
│   │   └── NetworkMonitorImpl.kt
│   │
│   └── repository
│       └── HeroRepositoryImpl.kt
│
├── domain
│   ├── model
│   │   └── Hero.kt
│   │
│   ├── repository
│   │   └── HeroRepository.kt
│   │
│   └── usecase
│       └── GetHeroUseCase.kt
│
├── presentation
│   ├── hero
│   │   ├── HeroContent.kt
│   │   ├── HeroScreen.kt
│   │   ├── HeroUiEvent
│   │   ├── CharacterViewModel.kt
│   │   ├── CharacterViewModelFactory.kt
│   │   └── CharacterUiState.kt
│   │    
│   └── components
│       ├── HeroCard.kt
│       ├── HeroInput
│       ├── HeroUiEffect.kt
│       └── LoadingIndicator.kt
│
└── di
    └── ServiceLocator.kt
```