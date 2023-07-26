package com.example.uas2020003.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



import com.example.uas2020003.R
import com.example.uas2020003.model.KopiModel

//import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class adapterkopi(var activity: Activity, var data: ArrayList<KopiModel>): RecyclerView.Adapter<adapterkopi.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvKode = view.findViewById<TextView>(R.id.tvkdkopi)
        val tvNama = view.findViewById<TextView>(R.id.tvnama)
        val tvJenis = view.findViewById<TextView>(R.id.tvjenis)
        val tvHarga = view.findViewById<TextView>(R.id.tvharga)
        val tvFoto = view.findViewById<ImageView>(R.id.tvfoto)


    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kopi, parent,false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvKode.text = a.kdkopi
        holder.tvNama.text = a.nama
        holder.tvJenis.text = a.jenis
        holder.tvHarga.text = a.harga

        Glide.with(context)
            .load("http://192.168.95.247/larapel-ku/storage/app/public/${a.foto}")
            .into(holder.tvFoto)






    }

    override fun getItemCount(): Int {
        return data.size
    }
}