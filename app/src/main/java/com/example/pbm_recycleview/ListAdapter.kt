package com.example.pbm_recycleview

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//extend ke class rvadapter

class ListAdapter (private val arrayList: ArrayList<classPahlawan>)
    : RecyclerView.Adapter<ListAdapter.ListHolder>(){
    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView : ImageView = itemView.findViewById(R.id.imgview)
        val textName : TextView = itemView.findViewById(R.id.textnama)
        val textDes : TextView = itemView.findViewById(R.id.textdesk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListHolder {
        //inflate layout item data
        val v : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ListHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListHolder, position: Int) {
       //menempatkan data resource ke dlm arraylist
        //mengatur tata letak nya sesuai item_data >> findViewById >> class list holder >>di hubungkan ke onBind
        val  (nama, deskripsi, foto) = arrayList[position]
        holder.imgView.setImageResource(foto)
        holder.textName.text = nama
        holder.textDes.text = deskripsi

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}