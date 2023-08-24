package com.rebecca.apiassessmenttest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rebecca.apiassessmenttest.databinding.PostsListBinding
import com.rebecca.apiassessmenttest.models.Posts

class PostsAdapter(var postsList: List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>()

{
//    fun updatePosts(newProducts: List<Posts>) {
//        postsList = newProducts
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsListBinding.inflate(LayoutInflater.from(parent.context), parent,
            false
        )
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPosts = postsList[position]
        val binding = holder.binding

        binding.tvId.text = currentPosts.id.toString()
        binding.tvTitle.text = currentPosts.title
        binding.tvBody.text = currentPosts.body


//
//        Picasso
//            .get()
//            .load(currentPosts.thumbnail)
//            .transform(CropCircleTransformation())
//            .into(binding.ivThumbnail)
  }

    override fun getItemCount(): Int {
        return postsList.size
    }


    class PostsViewHolder(var binding: PostsListBinding) :
        RecyclerView.ViewHolder(binding.root)
}