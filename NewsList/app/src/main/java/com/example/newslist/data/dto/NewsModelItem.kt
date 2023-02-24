package com.example.newslist.data.dto


import com.google.gson.annotations.SerializedName

data class NewsModelItem(
    @SerializedName("events")
    val events: List<Any?>?,
    @SerializedName("featured")
    val featured: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("launches")
    val launches: List<Any?>?,
    @SerializedName("newsSite")
    val newsSite: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?
)