package com.azrinurvani.axatest.presentation.activity

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azrinurvani.axatest.databinding.ActivityMainBinding
import com.azrinurvani.axatest.domain.model.PostsDto
import com.azrinurvani.axatest.model.PostsItem
import com.azrinurvani.axatest.model.Resource
import com.azrinurvani.axatest.presentation.adapter.ContentAdapter

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by  viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeObservers()
    }

    private fun subscribeObservers(){
        viewModel.getAllPostsList().observe(this@MainActivity){
            when(it){
                is Resource.Loading -> {
                    Log.d(javaClass.name, "subscribeObservers: loading")
                }
                is Resource.Success ->{
                    Log.d(javaClass.name, "subscribeObservers: success")
                    val postAdapter = ContentAdapter(it.data ?: emptyList())
                    binding.rvMain.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = postAdapter
                    }

                }
                is Resource.Error ->{
                    Log.e(javaClass.name, "subscribeObservers: ${it.message}")
                }
            }
        }
    }

}
