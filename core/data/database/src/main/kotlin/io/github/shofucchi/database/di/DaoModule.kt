package io.github.shofucchi.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.shofucchi.database.AppDatabase
import io.github.shofucchi.database.dao.PhotoDao

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun providePhotoDao(appDatabase: AppDatabase): PhotoDao = appDatabase.photoDao()
}