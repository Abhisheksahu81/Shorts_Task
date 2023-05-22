package com.example.shorts_task

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shorts_task.adapter.Adapter
import com.example.shorts_task.api.ApiInterface
import com.example.shorts_task.api.ApiUtilities
import com.example.shorts_task.model.Comment
import com.example.shorts_task.model.Creator
import com.example.shorts_task.model.Post
import com.example.shorts_task.model.Reaction
import com.example.shorts_task.model.Submission
import com.example.shorts_task.ui.theme.Shorts_TaskTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    private lateinit var rv : RecyclerView;
    private var currentpage = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)

        var list = mutableListOf<Post>()

        var adapter = Adapter(list, this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        runBlocking {
            launch(Dispatchers.IO ) {
                Log.d("Api data", "Calling the API")

                val result = apiInterface.getData(currentpage)
                list = result.data.posts as MutableList<Post>

                Log.d("Api data " , result.toString())
                adapter.UpdateList(list)
            }
        }

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()


                // Check if the last visible item has been reached
                if (lastVisibleItemPosition == totalItemCount - 1) {
                    // Trigger your method here

                    runBlocking {
                        launch(Dispatchers.IO ) {
                            val result = apiInterface.getData(currentpage+1)
                            list.addAll(result.data.posts)

                            Log.d("Api data " , result.toString())

                        }
                        adapter.UpdateList(list)
                    }
                    currentpage++;
                }
            }
        })




    }
}

