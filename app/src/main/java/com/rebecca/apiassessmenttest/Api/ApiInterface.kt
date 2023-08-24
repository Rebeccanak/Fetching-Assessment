package com.rebecca.apiassessmenttest.Api

import com.rebecca.apiassessmenttest.models.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/posts")
    suspend fun getPost(): Response<PostsResponse>
    fun getPosts()
    //
}