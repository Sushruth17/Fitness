package com.seventeen.fitness.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.gms.common.api.BooleanResult
import com.seventeen.fitness.R
import com.seventeen.fitness.model.Post

class PostsAdapter(private val activity: Context,
                  private val postList: ArrayList<Post>)
    : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    var liked: Boolean = false
    var saved: Boolean = false


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.unit_posts, p0, false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {


        val bounceAnim = AnimationUtils.loadAnimation(activity, R.anim.bounce)

        p0.name.text = postList[p1].name
        p0.likes.text = postList[p1].likes +" "+"likes"
        p0.description.text = postList[p1].description

        Glide.with(activity)
            .load(postList[p1].logo)
            .into(p0.logo)

        Glide.with(activity)
            .load(postList[p1].photo)
            .into(p0.photo)

        p0.like.setOnClickListener {
            p0.like.startAnimation(bounceAnim)
            if (!liked) { liked = true
                p0.like.setImageResource(R.drawable.ic_liked) }
            else{ liked = false
                p0.like.setImageResource(R.drawable.ic_like) }
        }

        p0.save.setOnClickListener {
            p0.save.startAnimation(bounceAnim)
            if (!saved) { saved = true
                p0.save.setImageResource(R.drawable.ic_saved) }
            else{ saved = false
                p0.save.setImageResource(R.drawable.ic_save) }
        }



    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.brand_name)
        val logo = itemView.findViewById<ImageView>(R.id.logo)
        val photo = itemView.findViewById<ImageView>(R.id.post_img)
        val likes = itemView.findViewById<TextView>(R.id.likes_txt)
        val description = itemView.findViewById<TextView>(R.id.description_txt)
        val like = itemView.findViewById<ImageView>(R.id.like)
        val save = itemView.findViewById<ImageView>(R.id.save)

    }
}