package com.azrinurvani.axatest.domain.repository

import android.util.Log
import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.domain.source.PostsDataSource
import com.azrinurvani.axatest.model.ApiResource

import com.azrinurvani.axatest.model.PostsItem
import com.azrinurvani.axatest.model.Resource
import com.azrinurvani.axatest.util.mapperResponseToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Singleton

@Singleton
class PostsRepositoryImpl(
    private val postsDataSource: PostsDataSource
) : PostsRepository {

    override  fun getAllPosts(): Flow<Resource<List<PostsDto>>> = flow {
//        emit(Resource.Loading())
        try{
            when(val response = postsDataSource.getAllPosts().single()){
                is ApiResource.Error ->{
                    emit(Resource.Error(message = response.error.toString()))
                }
                is ApiResource.Success ->{
                    Log.d(javaClass.name, "getAllPosts: success")
                    emit(Resource.Success(mapperResponseToDomain(response.data)))
                }
            }
        }catch (e : Exception){
            emit(Resource.Error(message = e.message.toString()))

        }
    }
}