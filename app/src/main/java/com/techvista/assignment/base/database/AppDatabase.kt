package com.techvista.assignment.base.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techvista.assignment.Modules.main.database.PostItemDao
import com.techvista.assignment.Modules.main.models.GetPostsResponse

@Database(entities = [(GetPostsResponse::class)], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun postItemDao(): PostItemDao
}