package Api


import Modelo.Usuario
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Clase necesaria para recoger/enviar los datos de/hacia la API Rest a través de ViewModel.
 */
class MainActivityViewModel : ViewModel() {

    val myResponse: MutableLiveData<Usuario> = MutableLiveData()
    val myResponseList: MutableLiveData<List<Usuario>> = MutableLiveData()

//    fun getPost(id:Int) {
//        viewModelScope.launch {
//            myResponse.value = UserNetwork.retrofit.getUsuario(id)
//            Log.e("Sergio","Dentro de buscar un registro con viewModel ${myResponse.value.toString()}")
//        }
//    }
//
//    fun getPosts() {
//        viewModelScope.launch {
//            myResponseList.value = UserNetwork.retrofit.getUsuarios()
//        }
//    }
//
//    fun addUserVM(u : Usuario) {
//        viewModelScope.launch {
//            myResponse.value = UserNetwork.retrofit.addUsuario(u)
//        }
//    }

}