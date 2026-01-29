package com.rasyidin.saltsubmissionapp.di

import com.rasyidin.saltsubmissionapp.domain.repository.ProductRepository
import com.rasyidin.saltsubmissionapp.domain.repository.ProductRepositoryImpl
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
    abstract fun provideProductRepository(impl: ProductRepositoryImpl): ProductRepository
}