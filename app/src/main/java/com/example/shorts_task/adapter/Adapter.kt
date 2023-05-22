package com.example.shorts_task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.shorts_task.R
import com.example.shorts_task.model.Post

class Adapter(private var items: List<Post>, val context : Context) : RecyclerView.Adapter<Adapter.Viewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.thumb_itm, parent, false)
        return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]

        Glide.with(context)
            .load(item.creator.pic) // Replace with the actual URL of the image
            .into(holder.creator_image)

        Glide.with(context)
            .load(item.submission.thumbnail) // Replace with the actual URL of the image
            .into(holder.thumb_image)

        holder.title.setText(item.submission.title);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public fun UpdateList(p1 : List<Post>) {
        items = p1;
        notifyDataSetChanged()
    }


    inner class Viewholder (private val view: View) :
        RecyclerView.ViewHolder(view) {

        val creator_image = view.findViewById<ImageView>(R.id.creator_photo);
        val title = view.findViewById<TextView>(R.id.thumb_name)
        val thumb_image = view.findViewById<ImageView>(R.id.thumb_image);
    }
}
