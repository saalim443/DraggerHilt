package com.example.mvvminfo.constant

import com.example.mvvminfo.singleton.MySingleton
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingltonModule {
//
//    @Provides
//    @Singleton
//    fun provideMySingleton(@ApplicationContext context: Context): MySingleton {
//        return MySingleton(context)
//    }
}