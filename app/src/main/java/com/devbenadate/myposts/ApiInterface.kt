package com.devbenadate.myposts


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
    @GET("/posts/{postsId}")
    fun getPostById(@Path("postsId")postId:Int): Call<Post>
    @GET("/comments")
    fun getCommets(): Call<List<Comment>>
}