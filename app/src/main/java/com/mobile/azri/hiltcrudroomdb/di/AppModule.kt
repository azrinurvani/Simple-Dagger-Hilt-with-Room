package com.mobile.azri.hiltcrudroomdb.di

import android.content.Context
import com.mobile.azri.hiltcrudroomdb.db.AppDao
import com.mobile.azri.hiltcrudroomdb.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(@ApplicationContext context : Context): AppDatabase{
        return AppDatabase.getDbInstance(context)
    }

    @Singleton
    @Provides
    fun getAppDao(appDb:AppDatabase): AppDao{
        return appDb.getAppDao()
    }
}