package pl.revolshen.simpleapp.data.mapper

import pl.revolshen.simpleapp.data.models.SerialHero
import pl.revolshen.simpleapp.domain.models.Hero

fun SerialHero.toDomain(): Hero {
    return Hero(
        id = id,
        name = name,
        imageUrl = image
    )
}