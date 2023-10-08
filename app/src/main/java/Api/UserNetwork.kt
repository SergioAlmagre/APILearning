package Api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Puente de conexión para conectar nuestra aplicación con la API Rest externa. No olvidemos los permisos de Internet en el MANIFEST.
 * Esta clase es usada cuando utilizamos ViewModel para interactuar con la API.
 */
object UserNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}
