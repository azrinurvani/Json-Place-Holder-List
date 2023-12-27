package com.azrinurvani.axatest.di

import com.azrinurvani.axatest.domain.repository.PostsRepository
import com.azrinurvani.axatest.domain.repository.PostsRepositoryImpl
import com.azrinurvani.axatest.domain.source.ApiService
import com.azrinurvani.axatest.domain.source.PostsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostsRepository(postsDataSource: PostsDataSource) : PostsRepository{
        return PostsRepositoryImpl(postsDataSource)
    }

}