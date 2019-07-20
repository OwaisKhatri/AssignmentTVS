package com.techvista.assignment.Modules.main.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Posts")
data class GetPostsResponse(

    @ColumnInfo(name = "body")
    @SerializedName("body")
    @Expose
    val body: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    val id: Int,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    val title: String,

    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    @Expose
    val userId: Int
)