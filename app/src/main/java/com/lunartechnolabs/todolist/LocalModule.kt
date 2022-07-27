package com.lunartechnolabs.todolist

import android.app.Application
import androidx.room.TypeConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@TypeConverters(Converter::class,ListConverter::class)
object LocalModule {

        @Singleton
        @Provides
        fun getAppDB(context: Application): AppDatabase {
            return AppDatabase.getAppDb(context) as AppDatabase
        }

        @Singleton
        @Provides
        fun getDao(appDB: AppDatabase): AppDao {
            return appDB.getDAO()
        }

}
