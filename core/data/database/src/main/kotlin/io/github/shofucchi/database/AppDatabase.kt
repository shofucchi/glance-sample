package io.github.shofucchi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.shofucchi.database.dao.PhotoDao
import io.github.shofucchi.database.model.Photo

@Database(entities = [Photo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}