package com.example.unscramblecomposefromscratch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel : androidx.lifecycle.ViewModel() {


    private val _userInput = MutableLiveData<String>()
    val userInput: LiveData<String> = _userInput

    private val _numOfTriesLeft = MutableLiveData(10)
    val numOfTriesLeft: LiveData<Int> = _numOfTriesLeft

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> = _isError

    private val _nextScrambledWord = MutableLiveData("")
    private val nextScrambledWord: LiveData<String> = _nextScrambledWord

    fun updateUserInput(string: String) {
        _userInput.value = string
    }

    fun updateNumOfTriesLeft(int: Int) {
        _numOfTriesLeft.value = int
    }

    fun updateScore(int: Int) {
        _score.value = int
    }

    fun updateIsError(bool: Boolean) {
        _isError.value = bool
    }

    fun getScrambledWord(): String {
// apply block is necessary since shuffle affects the original collection i.e. shuffles "in place" apply returns a new collection
        val unscrambledWord = WordsData().wordsList?.random().toCharArray().apply { shuffle() }
        _nextScrambledWord.value = unscrambledWord.joinToString(separator = "")



        return requireNotNull(nextScrambledWord.value)
    }

}
















