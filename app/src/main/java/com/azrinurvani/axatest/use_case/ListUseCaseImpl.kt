package com.azrinurvani.axatest.use_case

import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.domain.repository.PostsRepository
import com.azrinurvani.axatest.model.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListUseCaseImpl @Inject constructor(private val repository: PostsRepository) : ListUseCase{
     override fun getAllPosts(): Flow<Resource<List<PostsDto>>> {
          return repository.getAllPosts()
     }

}