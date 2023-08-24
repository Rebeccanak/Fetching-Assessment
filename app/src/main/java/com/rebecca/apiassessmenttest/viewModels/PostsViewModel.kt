package com.rebecca.apiassessmenttest.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rebecca.apiassessmenttest.models.Posts
import com.rebecca.apiassessmenttest.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel(){
        val postsRepo = PostsRepository()
        val postsLiveData  = MutableLiveData<List<Posts>>()
        val errorLiveData  = MutableLiveData<String>()

//    the activity is the ui the responsitory is the data source
//    middle man between the activity and

        fun fetchPosts(){
            viewModelScope.launch {
                val response = postsRepo.getPosts()
                if(response.isSuccessful){
                    postsLiveData.postValue(response.body()?.posts)
                }
                else{
                    errorLiveData.postValue(response.errorBody()?.string())


                }
            }
        }
    }

