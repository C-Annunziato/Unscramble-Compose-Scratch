package com.example.unscramblecomposefromscratch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel : androidx.lifecycle.ViewModel() {


    private val _userInput = MutableLiveData<String>()
    val userInput: LiveData<String> = _userInput

    private val _numOfTriesLeft = MutableLiveData<Int>(10)
    val numOfTriesLeft: LiveData<Int> = _numOfTriesLeft

    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int> = _score


    fun updateUserInput(string: String) {
        _userInput.value = string
    }

    fun updateNumOfTriesLeft(int: Int) {
        _numOfTriesLeft.value = int
    }

    fun updateScore(int: Int) {
        _score.value = int
    }

}