package com.example.apilearning

import Api.ServiceBuilder
import Api.UserAPI
import Modelo.Usuario
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apilearning.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBuscarId.setOnClickListener {
            var intentV1 = Intent(this, ListadoActivity::class.java)

            if (binding.edtBuscarId.text.trim().isEmpty()){
                Toast.makeText(this, "Rellene el campo con un número", Toast.LENGTH_SHORT).show()
            }
            else {
                intentV1.putExtra("operacion","buscar")
                intentV1.putExtra("valorBuscar",binding.edtBuscarId.text.toString())
                startActivity(intentV1)
            }
        }

        binding.btnListarTodos.setOnClickListener {
            var intentV1 = Intent(this, ListadoActivity::class.java)
            intentV1.putExtra("operacion","listar")
            startActivity(intentV1)
        }

        binding.btnAdd.setOnClickListener {

            val userInfo = Usuario(
                id = 1,
                email =  "alumno214@virgendegracia.com",
                first_name = "DAM2",
                last_name =  "Para el campo body",
                avatar =     "https://reqres.in/img/faces/2-image.jpg")

            //Sin ViewModel
            val retrofit = ServiceBuilder.buildService(UserAPI::class.java)
            retrofit.addUser(userInfo).enqueue(
                object : Callback<Usuario> {
                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Error al registrar", Toast.LENGTH_SHORT).show()
                        Log.e("Sergio", "Error al registrar")
                    }
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        val addedUser = response.body()
                        Toast.makeText(this@MainActivity, "Registro ok:  ${addedUser.toString()}",
                            Toast.LENGTH_SHORT).show()
                        Log.e("Sergio", "Registro ok:  ${addedUser.toString()}")
                    }
                }
            )

            //Con ViewModel
//            val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//
//            viewModel.addUserVM(userInfo)
//            viewModel.myResponse.observe(this) {
//                if (it?.id != null) {
//                    Toast.makeText(this@MainActivity, "Registro ok:  ${it.toString()}",Toast.LENGTH_SHORT).show()
//                    Log.e("Fernando", "Registro ok:  ${it.toString()}")
//                }
//                else {
//                    Toast.makeText(this@MainActivity, "Error al registrar",Toast.LENGTH_SHORT).show()
//                    Log.e("Fernando", "Error al registrar")
//                }
//            }
        }

    }
}