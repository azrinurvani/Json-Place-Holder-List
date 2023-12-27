package com.azrinurvani.axatest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azrinurvani.axatest.databinding.ItemJsonBinding
import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.model.PostsItem
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject



class ContentAdapter (val listContent :List<PostsDto> ) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = ItemJsonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentViewHolder(view)
    }

    override fun getItemCount() = listContent.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        listContent[position].let {
            holder.bindData(it)
        }
    }

    inner class ContentViewHolder(private val binding : ItemJsonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : PostsDto?){
            binding.apply {
                tvTitle.text = data?.title
                tvBody.text = data?.body
            }
        }
    }
}