package pl.revolshen.simpleapp

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pl.revolshen.simpleapp.di.ServiceLocator
import pl.revolshen.simpleapp.presentation.character.HeroScreen

class MainActivity : ComponentActivity() {

    //    private val mainVm by viewModels<MainViewModel>()
//    private val characterVm by viewModels<HeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val viewModel = HeroViewModel(
            getHero = ServiceLocator.getHeroUseCase,
            networkMonitor = NetworkMonitorImpl(this)
        )*/

        ServiceLocator.initialize(this)

        setContent {
            HeroScreen()

            /*var id by remember {
                mutableStateOf("")
            }

            Column {
                val hero by mainVm.hero.collectAsStateWithLifecycle()

                TextField(
                    value = id,
                    onValueChange = {
                        id = it
                        try {
                            val charId = it.toInt()
                            mainVm.performFetchSingleCharacter(charId)
                        } catch (e: Exception) { }
                    }
                )

                if (hero != null) Text(text = hero.toString())
            }*/
        }
    }
}
