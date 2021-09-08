package com.mobile.azri.hiltcrudroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase: RoomDatabase(){

    abstract fun getAppDao() : AppDao

    companion object{
        private var dbInstance : AppDatabase? = null

        fun getDbInstance(context: Context):AppDatabase{
            if (dbInstance==null){
                dbInstance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,AppDatabase::class.java,"MyDB"
                ).allowMainThreadQueries()
                    .build()
            }
            return dbInstance as AppDatabase
        }
    }
}