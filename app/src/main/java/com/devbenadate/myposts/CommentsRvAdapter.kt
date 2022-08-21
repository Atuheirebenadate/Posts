package com.devbenadate.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devbenadate.myposts.databinding.ActivityCommentsListItemBinding

class CommentsRvAdapter(var commentsList: List<Comment>):RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
       var binding=ActivityCommentsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentsList.get(position)
        with(holder.binding){
            tvName.text=currentComment.name.toString()
            tvbody.text=currentComment.body.toString()
        }
    }

    override fun getItemCount(): Int {
return  commentsList.size
    }
}
class CommentsViewHolder(var binding: ActivityCommentsListItemBinding):RecyclerView.ViewHolder(binding.root){

}