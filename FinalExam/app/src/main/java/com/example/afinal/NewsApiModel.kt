package com.example.afinal

data class News (

    val title: String,
    val description: String,
    val url: String,
    val author: String,
    val image: String,
    val published: String

)


data class NewsArr<T> (
    val news: T
)

