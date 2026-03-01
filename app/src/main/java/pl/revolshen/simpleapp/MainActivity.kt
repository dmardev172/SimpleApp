package pl.revolshen.simpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pl.revolshen.simpleapp.ui.theme.SimpleAppTheme

class MainActivity : ComponentActivity() {

    private val mainVm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var id by remember {
                mutableStateOf("")
            }

            Column {
                val character by mainVm.character.collectAsStateWithLifecycle()

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

                if (character != null) Text(text = character.toString())
            }
        }
    }
}
