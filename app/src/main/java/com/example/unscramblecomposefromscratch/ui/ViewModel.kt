package com.example.unscramblecomposefromscratch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unscramblecomposefromscratch.Data.MAX_NUM_OF_WORDS
import com.example.unscramblecomposefromscratch.Data.SCORE_INCREASE
import com.example.unscramblecomposefromscratch.Data.listOfWords
import kotlin.random.Random


const val TAG = "viewmodel"

class ViewModel : androidx.lifecycle.ViewModel() {


    private val _userInput = MutableLiveData<String>()
    val userInput: LiveData<String> = _userInput

    private val _numOfTriesLeft = MutableLiveData(MAX_NUM_OF_WORDS)
    val numOfTriesLeft: LiveData<Int> = _numOfTriesLeft

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> = _isError

    private val _nextScrambledWord = MutableLiveData("")
    val nextScrambledWord: LiveData<String> = _nextScrambledWord

    private val usedWordsList: MutableList<String> = mutableListOf()


    fun updateUserInput(string: String) {
        _userInput.value = string
    }

    private fun updateNumOfTriesLeft() {
        _numOfTriesLeft.value = _numOfTriesLeft.value?.minus(1)
    }

    private fun updateScore(int: Int) {
        _score.value = _score.value?.plus(int)
    }

    private fun updateIsError(bool: Boolean) {
        _isError.value = bool
    }

    private lateinit var currentWord: String


    fun checkGuess() {
        Log.i(TAG,"check guess called")
        Log.i(TAG,"${userInput.value}")
        Log.i(TAG,"${currentWord}")
        if (userInput.value.equals(currentWord, true)) {
            updateScore(SCORE_INCREASE)
            updateNumOfTriesLeft()
            nextScrambledWord()
        } else {
            updateIsError(true)
            updateNumOfTriesLeft()
        }
    }

    fun skipWord(){
        Log.i(TAG,"skip word called")
        nextScrambledWord()
        updateNumOfTriesLeft()
    }

    fun nextScrambledWord() {

        Log.i(TAG,"next scrambled word called")
        currentWord = listOfWords.shuffled().first()
        val scrambledWord = currentWord.toCharArray().apply { shuffle() }.joinToString("")

        // make sure the word is scrambled and its not a repeat of prior words
        if (scrambledWord != currentWord && !usedWordsList.contains(currentWord)) {
            _nextScrambledWord.value = scrambledWord
        } else {
            nextScrambledWord()
        }
    }

    fun resetGame() {
        if (numOfTriesLeft.value == 0) {
            usedWordsList.clear()
            _numOfTriesLeft.value = 10
            _score.value = 0
        }
    }
}


















