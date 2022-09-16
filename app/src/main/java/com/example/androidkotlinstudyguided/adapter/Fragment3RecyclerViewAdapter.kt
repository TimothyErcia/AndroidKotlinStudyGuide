package com.example.androidkotlinstudyguided.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.androidkotlinstudyguided.R
import com.example.androidkotlinstudyguided.model.Photos

class Fragment3RecyclerViewAdapter(_context: Context, _photos: ArrayList<Photos>):
    RecyclerView.Adapter<Fragment3RecyclerViewAdapter.mViewHolder>() {

    private val context = _context
    private var photoArray: ArrayList<Photos> = _photos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_list_item, parent, false)
        return mViewHolder(view)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.imageURL.text = photoArray[position].title
        val url = GlideUrl(photoArray[position].thumbnailUrl, LazyHeaders.Builder().addHeader("User-Agent", "your-user-agent").build())
        Glide.with(context)
            .asBitmap()
            .load(url)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        if(photoArray != null) {
            return photoArray.size
        }
        return 0
    }

    class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.photoImageView)
        val imageURL: TextView = itemView.findViewById(R.id.photoUrlTextView)
    }
}