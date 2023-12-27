package com.azrinurvani.axatest.use_case

import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.model.Resource
import kotlinx.coroutines.flow.Flow

interface ListUseCase {

    fun getAllPosts() : Flow<Resource<List<PostsDto>>>

}