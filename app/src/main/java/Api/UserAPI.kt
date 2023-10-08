package Api

import Modelo.Usuario
import retrofit2.Call
import retrofit2.http.*

/**
 * Interfaz de métodos que nos permitirán lanzar peticiones a la API.
 * Esta interfaz la usamos tanto para el modo con ViewModel como el modo sin ViewNodel. Se han separado con un comentario los métodos.
 */
interface UserAPI {

    /*
    Métodos usados para el acceso sin ViewModel.
     */
    @GET("users?page=2")
    fun getUsuarioss(): Call<MutableList<Usuario>>

    @GET("users/{id}")
    fun getUnUsuario(@Path("id") id:Int): Call<Usuario>

    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body userData: Usuario): Call<Usuario>

//---------------------------------------------------------------------------------

    /*
    Métodos usados para el acceso con ViewModel.
     */
//    @GET("posts/{id}")
//    suspend fun getUsuario(@Path("id") id:Int): Usuario
//
//    @GET("posts")
//    suspend fun getUsuarios(): MutableList<Usuario>
//
//    @POST("posts")
//    suspend fun addUsuario(@Body userData: Usuario): Usuario
}