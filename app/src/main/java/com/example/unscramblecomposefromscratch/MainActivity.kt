package com.example.unscramblecomposefromscratch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.unscramblecomposefromscratch.ui.MainScreen
import com.example.unscramblecomposefromscratch.ui.ViewModel
import com.example.unscramblecomposefromscratch.ui.theme.UnscrambleComposeFromScratchTheme

const val TAG = "main"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = ViewModelProvider(this)[ViewModel::class.java]
            val gameOver = vm.gameOver.observeAsState().value
            val score = vm.score.observeAsState().value

            LaunchedEffect(true) { vm.nextScrambledWord() }

            when (gameOver) {
                false -> MainScreen().Screen(
                    vm = vm,
                    userGuess = vm.userInput,
                    nextWord = vm.nextScrambledWord
                )
                true -> score?.let { MainScreen().EndScreen(
                    score = it,
                    vm = vm
                ) }
            }
        }
    }
}

