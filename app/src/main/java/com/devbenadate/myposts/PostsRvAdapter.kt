package com.devbenadate.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devbenadate.myposts.databinding.PostListItemBinding

class PostsRvAdapter(var postList: List<Post>):
        RecyclerView.Adapter<postViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
            var binding=PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return postViewHolder(binding)

        }
        override fun onBindViewHolder(holder: postViewHolder, position: Int) {
            var currentpost=postList.get(position)
            holder.binding.tvuserId.text=currentpost.userId.toString()
            holder.binding.tvId.text=currentpost.id.toString()
            holder.binding.tvTitle.text=currentpost.title
            holder.binding.tvBody.text=currentpost.body
            val context=holder.itemView.context
            holder.binding.cvPost.setOnClickListener{
                val intent=Intent(context,CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentpost.id)
                context.startActivity(intent)

            }

        }

        override fun getItemCount(): Int {
            return postList.size

        }
    }
class postViewHolder(val binding:PostListItemBinding):RecyclerView.ViewHolder(binding.root)
