package com.rebecca.apiassessmenttest.Api

interface ApiInterface {
    @POST("/posts")
    suspend fun getProducts(): Response<ProductResponse>
    //
}