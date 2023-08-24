package com.rebecca.apiassessmenttest.repository

import com.rebecca.apiassessmenttest.Api.ApiClient
import com.rebecca.apiassessmenttest.Api.ApiInterface
import com.rebecca.apiassessmenttest.models.Posts
import com.rebecca.apiassessmenttest.models.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun  getPosts() :Response<List<Posts>>{
        return withContext(Dispatchers.IO){
            apiClient.getPost()
        }

    }


}