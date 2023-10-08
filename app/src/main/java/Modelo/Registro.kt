package Modelo

/**
 * Usada por la RecyclerView para representar los datos.
 */
data class Registro(
    val id: Int,
    val email:String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
