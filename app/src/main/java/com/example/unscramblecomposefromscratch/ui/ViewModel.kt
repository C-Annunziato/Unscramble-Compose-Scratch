package com.example.unscramblecomposefromscratch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unscramblecomposefromscratch.Data.listOfWords
import kotlin.random.Random


const val TAG = "viewmodel"

class ViewModel : androidx.lifecycle.ViewModel() {


    private val _userInput = MutableLiveData<String>()
    val userInput: LiveData<String> = _userInput

    private val _numOfTriesLeft = MutableLiveData(10)
    val numOfTriesLeft: LiveData<Int> = _numOfTriesLeft

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> = _isError

    private val _nextScrambledWord = MutableLiveData("hello")
    val nextScrambledWord: LiveData<String> = _nextScrambledWord

    private val usedWordsList: MutableList<String> = mutableListOf()


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

    fun nextScrambledWord() {
        val currentWord = listOfWords.shuffled().last()

        val scrambledWord = currentWord.toCharArray().apply { shuffle() }.joinToString("")

        if (scrambledWord != currentWord) {
            _nextScrambledWord.value = scrambledWord
        } else {
            nextScrambledWord()
        }
    }
}
















