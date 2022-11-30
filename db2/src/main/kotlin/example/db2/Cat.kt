package example.db2

import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class Cat(@KomapperId val id: Int, val name: String)