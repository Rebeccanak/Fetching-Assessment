package com.rebecca.apiassessmenttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rebecca.apiassessmenttest.databinding.ActivityMainBinding
import com.rebecca.apiassessmenttest.viewModels.PostsViewModel

class MainActivity : AppCompatActivity() {
    val postsViewModel: PostsViewModel by viewModels()


    private lateinit var postsAdapter: PostsAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView: RecyclerView = binding.rvPosts
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        postsAdapter = PostsAdapter(emptyList())
        recyclerView.adapter = postsAdapter
    }

    override fun onResume() {
        super.onResume()

        postsViewModel.fetchPosts()
        postsViewModel.postsLiveData.observe(this, Observer { postsList ->
var postAdapt=PostsAdapter(postsList?: emptyList())
binding.rvPosts.layoutManager=LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter=postAdapt

            Toast.makeText(
                baseContext,
                "Fetched ${postsList?.size} products",
                Toast.LENGTH_LONG
            ).show()

        })

        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()


        })
       }
    }
