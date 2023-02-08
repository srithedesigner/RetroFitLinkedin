package com.example.retrofitlinkedin


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.retrofitlinkedin.models.Post
import com.example.retrofitlinkedin.ui.theme.RetroFitLinkedinTheme

class DetailPost : ComponentActivity() {

    val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var postID: Int = 0

        setContent {
            RetroFitLinkedinTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    postID = this.intent.getIntExtra("postID", 0)
                    detailViewModel.getPost(postId = postID + 1)
                    PostDetails(post = detailViewModel.post)
                
                }

            }
        }
    }
}

@Composable
fun PostDetails(post: Post){
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 4.dp),
            fontWeight = FontWeight.Bold,
            text = "ID# ${post.id}"
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.headlineSmall,
            text = post.title)

        Divider(color = androidx.compose.ui.graphics.Color.Black, thickness = 2.dp)

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 20.dp),
            overflow = TextOverflow.Ellipsis,
            text = post.body)

    }
}
