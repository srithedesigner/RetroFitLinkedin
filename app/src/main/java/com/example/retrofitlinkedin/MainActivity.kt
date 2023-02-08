package com.example.retrofitlinkedin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitlinkedin.models.Post
import com.example.retrofitlinkedin.ui.theme.RetroFitLinkedinTheme

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            RetroFitLinkedinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainViewModel.fetchPosts()
                    PostList(postList = mainViewModel.posts, this)
                }
            }
        }
    }
}


@Composable
fun PostList(postList: List<Post>, context: Context) {
    LazyColumn() {
        itemsIndexed(items = postList) {id, item ->
            Post(item, onClick = {

//                Toast.makeText(context, "onClick working!", Toast.LENGTH_LONG).show()
//                println("Hi")
                val intent = Intent(context, DetailPost::class.java)
                intent.putExtra("postID", id)
                context.startActivity(intent)
            })
        }
    }
}

@Composable
fun Post(post: Post, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable (
                onClick = onClick
            )

    ) {
        Text(
            modifier = Modifier.padding(top = 4.dp),
            fontWeight = FontWeight.Bold,
            text = "ID# ${post.id.toString()}"
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.headlineSmall,
            text = post.title)
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            text = post.body)
    }
}