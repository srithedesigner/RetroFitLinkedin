package com.example.retrofitlinkedin.models


//{
//    "userId": 1,
//    "id": 1,
//    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//}


data class Post(
    val userID: Int = 0,
    var id: Int = 0,
    val title: String = "",
    val body: String = ""
)
