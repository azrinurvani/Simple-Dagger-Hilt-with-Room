package com.mobile.azri.hiltcrudroomdb.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecords():List<UserEntity>{
        return appDao.getRecords()
    }

    fun insertRecord(userEntity: UserEntity){
        return appDao.insertRecord(userEntity)
    }
}