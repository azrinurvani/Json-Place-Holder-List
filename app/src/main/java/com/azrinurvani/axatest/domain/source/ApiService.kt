package com.azrinurvani.axatest.domain.source

import com.azrinurvani.axatest.model.PostsItem
import com.azrinurvani.axatest.model.ResponsePosts
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface ApiService {

    @GET("/posts")
    suspend fun getPosts() : List<PostsItem>

}