package com.example.calc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TagsAdapter(private val tags: ArrayList<String>, private val img:
ArrayList<Int>) : RecyclerView.Adapter<TagsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tagTV: TextView = view.findViewById<View>(R.id.tagTV) as TextView
        val imageCats: ImageView = view.findViewById(R.id.image_cats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.tags_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tag = tags[position]
        val imgRes = img[position]

        holder.tagTV.text = tag
        holder.imageCats.setImageResource(imgRes)

    }

    override fun getItemCount(): Int {
        return tags.size
    }

}