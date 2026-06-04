package pl.revolshen.simpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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
