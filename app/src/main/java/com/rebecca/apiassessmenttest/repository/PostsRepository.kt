package com.rebecca.apiassessmenttest.repository

import com.rebecca.apiassessmenttest.Api.ApiClient
import com.rebecca.apiassessmenttest.Api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    //when the getProducts() gets invoked it returns the api response ProductResponse

    suspend fun  getProducts(): Response<ProductResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }
}