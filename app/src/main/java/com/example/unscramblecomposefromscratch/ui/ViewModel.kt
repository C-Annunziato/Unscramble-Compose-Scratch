package com.example.unscramblecomposefromscratch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unscramblecomposefromscratch.Data.MAX_NUM_OF_WORDS
import com.example.unscramblecomposefromscratch.Data.SCORE_INCREASE
import com.example.unscramblecomposefromscratch.Data.listOfWords


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

    private val _gameOver = MutableLiveData(false)
    val gameOver: LiveData<Boolean> = _gameOver

    private val _nextScrambledWord = MutableLiveData("")
    val nextScrambledWord: LiveData<String> = _nextScrambledWord

    private val usedWordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

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


    fun checkGuess() {
        if (userInput.value.equals(currentWord, true)) {
            updateScore(SCORE_INCREASE)
            updateNumOfTriesLeft()
            nextScrambledWord()
            _userInput.value = ""
        } else {
            updateIsError(true)
            if (userInput.value != null && userInput.value != "") {
                updateNumOfTriesLeft()
                _userInput.value = ""
            }
        }
    }

    fun skipWord() {
        nextScrambledWord()
        updateNumOfTriesLeft()
        _userInput.value = ""
    }


    fun nextScrambledWord() {
        currentWord = listOfWords.shuffled().first()
        val scrambledWord = currentWord.toCharArray().apply { shuffle() }.joinToString("")
        if (numOfTriesLeft.value!! > 0) {
            // make sure the word is scrambled and its not a repeat of prior words
            if (scrambledWord != currentWord && !usedWordsList.contains(currentWord)) {
                usedWordsList.add(currentWord)
                _nextScrambledWord.value = scrambledWord
                updateIsError(false)
            } else {
                nextScrambledWord()
                updateNumOfTriesLeft()
            }
        } else {
            _gameOver.value = true
        }
    }

    fun resetGame() {
        Log.i(TAG, "${numOfTriesLeft.value} reset game called")
        usedWordsList.clear()
        _numOfTriesLeft.value = 10
        _score.value = 0
        _gameOver.value = false
    }
}



















