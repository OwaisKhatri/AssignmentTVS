package com.techvista.assignment.Modules.main.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.techvista.assignment.Modules.main.models.GetPostsResponse

@Dao
interface PostItemDao {

    @Query("SELECT * FROM Posts")
    fun getAllPosts(): List<GetPostsResponse>

    @Insert
    fun insert(vararg postItem: GetPostsResponse)

    @Query("DELETE FROM Posts")
    fun deleteAll()
}