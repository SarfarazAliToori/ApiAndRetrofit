package com.example.apicallusingretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    var myArrayList: ArrayList<MyDataClass> = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_view, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val currentItems = myArrayList[position]
        Glide.with(holder.mImage.context).load(currentItems.image).into(holder.mImage)
        holder.category.text = currentItems.category
        holder.price.text = currentItems.price
        holder.title.text = currentItems.title
        holder.description.text = currentItems.description
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    fun updateArrayList(updatedArry: ArrayList<MyDataClass>) {
        myArrayList.clear()
        myArrayList.addAll(updatedArry)
        notifyDataSetChanged()
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImage: ImageView = itemView.findViewById(R.id.img_view)
        val price: TextView = itemView.findViewById(R.id.tv_price)
        val category: TextView = itemView.findViewById(R.id.tv_category)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val description: TextView = itemView.findViewById(R.id.tv_description)
    }
}