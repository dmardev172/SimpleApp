package pl.revolshen.simpleapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pl.revolshen.simpleapp.domain.models.Hero

@Composable
fun HeroCard(hero: Hero) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = hero.imageUrl,
                contentDescription = hero.name,
                modifier = Modifier.fillMaxWidth().height(220.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "ID: ${hero.id}")
            Text(text = hero.name, style = MaterialTheme.typography.headlineSmall)
        }
    }
}