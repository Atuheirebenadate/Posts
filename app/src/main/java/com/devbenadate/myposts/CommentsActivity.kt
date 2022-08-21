package com.devbenadate.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbenadate.myposts.databinding.ActivityCommentsBinding
import com.devbenadate.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostsById()
        setupToolbar()
        fetchCommentsId()

    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0
    }

    fun fetchPostsById() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    binding.tvPostTitle.text = post?.title
                    binding.tvPostBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setupToolbar(){
        setSupportActionBar(binding.toolbarComments)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    fun fetchCommentsId(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getCommets()
        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if(response.isSuccessful){
                    var comment=response.body()
                    Toast.makeText(baseContext,"${comment!!.size}c comments",Toast.LENGTH_LONG).show()
                    var commentadapter= CommentsRvAdapter(comment)
                    binding.rvComments.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvComments.adapter=commentadapter

                }

                }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {

            }
        })
}}
