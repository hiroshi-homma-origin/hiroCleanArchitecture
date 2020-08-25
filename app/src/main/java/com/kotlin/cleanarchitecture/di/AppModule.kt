package com.kotlin.cleanarchitecture.di

import com.kotlin.cleanarchitecture.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @App
    @Provides
    fun provideContext(application: MyApplication): MyApplication {
        return application
    }
}
