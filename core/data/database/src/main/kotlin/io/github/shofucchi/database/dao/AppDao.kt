package io.github.shofucchi.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.shofucchi.database.model.Photo

@Dao
interface PhotoDao {
    @Query(value = "SELECT * FROM photos WHERE id in (:id)")
    fun findBy(id: Int): Photo

    @Insert
    fun insert(photo: Photo)

    @Delete
    fun delete(photo: Photo)
}