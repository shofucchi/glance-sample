package io.github.shofucchi.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "image_url") val imageUrl: String?
)
