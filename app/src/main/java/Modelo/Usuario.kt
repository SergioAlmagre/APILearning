package Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Clase serializable que interactuará con la API.
 */
data class Usuario(@SerializedName("id")
                   val id: Int? = null,

                   @SerializedName("email")
                   val email: String? = null,

                   @SerializedName("first_name")
                   val first_name: String? = null,

                   @SerializedName("last_name")
                   val last_name: String? = null,

                   @SerializedName("avatar")
                   val avatar: String? = null)

                    :Serializable{
}