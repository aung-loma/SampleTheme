package com.example.sampletheme.di

import android.content.Context
import com.example.sampletheme.provider.AppThemeProvider
import com.example.sampletheme.provider.ThemeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProviderModule {
    @Provides
    @Singleton
    fun provideThemeProvider(@ApplicationContext context: Context): ThemeProvider {
        return AppThemeProvider(context)
    }
}