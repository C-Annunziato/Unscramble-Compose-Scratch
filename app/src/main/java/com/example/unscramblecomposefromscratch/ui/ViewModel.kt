package com.example.unscramblecomposefromscratch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel: androidx.lifecycle.ViewModel() {

val _textInput = MutableLiveData<String>("")
     val textInput: LiveData<String> = _textInput

fun functionChangeText(string: String){
     _textInput.value = string
}

}