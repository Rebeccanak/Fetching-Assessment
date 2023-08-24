package com.rebecca.apiassessmenttest.models

data class PostsResponse(
var post:List<Posts>,
val userId: Int,
val id: Int,
val title: String,
val body: String


)


