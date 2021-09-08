package com.mobile.azri.hiltcrudroomdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobile.azri.hiltcrudroomdb.databinding.ActivityMainBinding
import com.mobile.azri.hiltcrudroomdb.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        saveRecords()
        subscribeObservers()
    }

    private fun saveRecords() {
        binding.apply {
            btnSave.setOnClickListener {
                val userEntity = UserEntity(name = edtName.text.toString())
                viewModel.insertRecord(userEntity)
                edtName.setText("")
            }
        }
    }

    private fun subscribeObservers(){
        viewModel.getRecordsObserver().observe(this,object : Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                binding.tvResult.setText("")
                t?.forEach{
                    binding.tvResult.append(it.name+"\n")
                }
            }

        })
    }
}