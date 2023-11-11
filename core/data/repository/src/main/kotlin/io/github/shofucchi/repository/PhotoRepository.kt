package io.github.shofucchi.repository

import io.github.shofucchi.database.dao.PhotoDao
import io.github.shofucchi.database.model.Photo
import io.github.shofucchi.network.Synchronizer
import javax.inject.Inject

interface PhotoRepository : Synchronizer {
    fun findBy(id: Int): Photo
    fun insert(photo: Photo)
    fun delete(photo: Photo)
}

class PhotoRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao,
) : PhotoRepository {
    override fun findBy(id: Int): Photo = photoDao.findBy(id)
    override fun insert(photo: Photo) = photoDao.insert(photo)
    override fun delete(photo: Photo) = photoDao.delete(photo)
    override suspend fun synchronize() {
        // todo: Sync network response with database
    }
}