package com.rebecca.apiassessmenttest.Api

import com.rebecca.apiassessmenttest.models.Posts
import retrofit2.Response
import retrofit2.http.GET
interface ApiInterface {
    @GET("/posts")
    suspend fun getPost(): Response<List<Posts>>
}