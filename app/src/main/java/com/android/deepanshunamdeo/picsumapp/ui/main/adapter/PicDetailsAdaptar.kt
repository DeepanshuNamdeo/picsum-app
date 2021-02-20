package com.android.deepanshunamdeo.picsumapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.deepanshunamdeo.picsumapp.R
import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import com.bumptech.glide.Glide

class PicDetailsAdapter(val picDetailsList : ArrayList<PicDetails>, val context: Context) : RecyclerView.Adapter<PicDetailsAdapter.PicDetailViewHolder>() {

    class PicDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView_item_name : TextView = itemView.findViewById(R.id.textView_author)
        val imageView_picture : ImageView = itemView.findViewById(R.id.imageView_picture)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicDetailViewHolder {
       return PicDetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.picture_detail_item_layout, parent,
                false
            ) )
    }

    override fun onBindViewHolder(holder: PicDetailViewHolder, position: Int) {
        val currentItem  = picDetailsList[position]
        holder.textView_item_name.text = currentItem.author
        Glide.with(holder.imageView_picture.context).load("https://picsum.photos/300/300?image="+currentItem.id).into(holder.imageView_picture);

    }

    override fun getItemCount(): Int {
       return picDetailsList.size
    }

    fun addData(picture: List<PicDetails>) {
        picDetailsList.addAll(picture)
    }
}