package Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Puente de conexión para conectar nuestra aplicación con la API Rest externa. No olvidemos los permisos de Internet en el MANIFEST.
 * Esta clase es usada cuando NO utilizamos ViewModel para interactuar con la API.
 */
object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}