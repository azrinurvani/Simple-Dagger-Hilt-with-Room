package com.mobile.azri.hiltcrudroomdb.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.azri.hiltcrudroomdb.db.RoomRepository
import com.mobile.azri.hiltcrudroomdb.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel(){

    var userData : MutableLiveData<List<UserEntity>> = MutableLiveData()


    fun getRecordsObserver(): MutableLiveData<List<UserEntity>>{

        return userData
    }

    fun loadRecords(){
        val list = repository.getRecords()
        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity){
        repository.insertRecord(userEntity)
        loadRecords()
    }
}