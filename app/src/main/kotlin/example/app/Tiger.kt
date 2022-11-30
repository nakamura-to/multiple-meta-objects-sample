package example.app

import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class Tiger(@KomapperId val id: Int, val name: String)