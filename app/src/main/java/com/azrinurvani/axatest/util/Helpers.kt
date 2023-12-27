package com.azrinurvani.axatest.util

import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.model.PostsItem


fun mapperResponseToDomain(response : List<PostsItem?>) : List<PostsDto>{
    val mutableList : MutableList<PostsDto> = mutableListOf()
    response.forEach {
        PostsDto(
          userId = it?.userId ?: 0,
          id = it?.id ?: 0,
          title = it?.title ?: "",
          body = it?.body ?: ""
        ).let(mutableList::add)
    }
    return mutableList
}