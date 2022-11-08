package com.example.memogram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PhotosAdapter(private val photoList:ArrayList<Photos>) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    class PhotosViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageView :ImageView = itemView.findViewById(R.id.gridPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return PhotosViewHolder(view);
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
         val photos = photoList[position]
          holder.imageView.setImageResource(photos.image)

    }

    override fun getItemCount(): Int {
      return photoList.size
    }

}