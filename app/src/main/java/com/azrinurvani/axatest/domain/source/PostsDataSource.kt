package com.azrinurvani.axatest.domain.source

import android.util.Log
import com.azrinurvani.axatest.model.ApiResource
import com.azrinurvani.axatest.model.PostsItem
import com.azrinurvani.axatest.model.ResponsePosts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsDataSource @Inject constructor(
    private val api : ApiService
)  {
    suspend fun getAllPosts() : Flow<ApiResource<List<PostsItem>>> = flow {
        try {
            emit(
                ApiResource.Success(
                    api.getPosts()
                )
            )
        }catch (e : Throwable){
            emit(ApiResource.Error(e))
            Log.e(javaClass.name, "getAllPosts: ${e.message}" )
        }
    }
}