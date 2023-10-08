package Adaptadores

import Modelo.Registro
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apilearning.R


/**
 * Adaptador de la RecyclerView
 */
class MiAdaptadorRV (private var context: Context, private var datos: ArrayList<Registro>) : RecyclerView.Adapter<MiAdaptadorRV.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // set the data in items
        holder.idR.text = datos[position].id.toString()
        holder.email.text = datos[position].email
        holder.first_name.text = datos[position].first_name
        holder.last_name.text = datos[position].last_name
        Glide.with(context).load(datos[position].avatar).into(holder.avatar)




        holder.itemView.setOnClickListener {
            Toast.makeText(context, datos[position].toString(), Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return datos.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var first_name: TextView = itemView.findViewById<View>(R.id.txtFirstName) as TextView
        var last_name: TextView = itemView.findViewById<View>(R.id.txtSecondName) as TextView
        var email: TextView = itemView.findViewById<View>(R.id.txtEmail) as TextView
        var idR: TextView = itemView.findViewById<View>(R.id.txtID) as TextView
        var avatar: ImageView = itemView.findViewById<View>(R.id.avatar) as ImageView
    }
}