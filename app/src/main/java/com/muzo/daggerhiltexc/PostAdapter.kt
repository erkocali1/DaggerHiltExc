package com.muzo.daggerhiltexc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muzo.daggerhiltexc.databinding.ItemRowBinding

class PostAdapter(private val list: List<Post>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(var binding:ItemRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item:Post){
            binding.body.text=item.body
            binding.title.text=item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item=list[position]
        holder.bind(item)

    }
    override fun getItemCount(): Int {
        return list.size
    }

}