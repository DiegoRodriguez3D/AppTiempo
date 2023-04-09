package com.diegorb.tiempo.di

import com.diegorb.tiempo.data.repository.TiempoRepositoryImpl
import com.diegorb.tiempo.domain.repository.TiempoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTiempoRepository(
        tiempoRepositoryImpl: TiempoRepositoryImpl
    ): TiempoRepository
}