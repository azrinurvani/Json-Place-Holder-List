package com.azrinurvani.axatest.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.azrinurvani.axatest.use_case.ListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ListUseCaseImpl
) : ViewModel(){

    fun getAllPostsList() = useCase.getAllPosts().asLiveData()
}