package example.db1

import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class Dog(@KomapperId val id: Int, val name: String)