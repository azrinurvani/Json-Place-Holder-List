package com.azrinurvani.axatest.di

import com.azrinurvani.axatest.use_case.ListUseCase
import com.azrinurvani.axatest.use_case.ListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class  UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsNewsUseCase(useCaseImpl : ListUseCaseImpl) : ListUseCase
}