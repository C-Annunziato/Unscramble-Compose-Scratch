package com.example.unscramblecomposefromscratch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel: androidx.lifecycle.ViewModel() {


val _userInput = MutableLiveData<String>()
    val userInput: LiveData<String>  = _userInput

    fun changeString(string: String){
        _userInput.value = string
    }


}