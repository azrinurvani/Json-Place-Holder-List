package com.azrinurvani.axatest.domain.repository

import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.model.Resource
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getAllPosts() : Flow<Resource<List<PostsDto>>>
}