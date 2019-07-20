package com.techvista.assignment.base.di.modules

import android.content.Context
import androidx.room.Room
import com.techvista.assignment.Modules.main.database.PostItemDao
import com.techvista.assignment.base.database.AppDatabase
import com.techvista.assignment.base.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
            AppDatabase::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun providePostItemDao(appDatabase: AppDatabase): PostItemDao {
        return appDatabase.postItemDao()
    }
}