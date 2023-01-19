package com.example.unscramblecomposefromscratch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class MainScreen() {

    @Composable
    fun Screen() {

       var text by rememberSaveable { mutableStateOf("") }

        Column() {
            WordsAndScore()
            ScrambledWordTextView()
            EnterGuessTextField(onTextChange = { string -> text = string },valueEntered = text)
            SkipAndSubmitButtons()
        }
    }


    private @Composable
    fun EnterGuessTextField(
        onTextChange: (String) -> Unit,
        valueEntered: String
    ) {
            OutlinedTextField(
                value = valueEntered,
                onValueChange = onTextChange,
                isError = false,
                label = { Text(text = "input") }
            )
    }


    private @Composable
    fun SkipAndSubmitButtons() {


    }

    private @Composable
    fun ScrambledWordTextView() {
        TODO("Not yet implemented")
    }

    private @Composable
    fun WordsAndScore() {
        TODO("Not yet implemented")
    }

}