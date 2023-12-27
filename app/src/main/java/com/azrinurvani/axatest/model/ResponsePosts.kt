package com.azrinurvani.axatest.model

import com.google.gson.annotations.SerializedName

data class ResponsePosts(

	@field:SerializedName("ResponsePosts")
	val responsePosts: List<PostsItem?>? = null
)

data class PostsItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
