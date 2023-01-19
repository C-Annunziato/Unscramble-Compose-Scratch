package com.example.unscramblecomposefromscratch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData

class MainScreen() {

    @Composable
    fun Screen(modifier: Modifier = Modifier, vm: ViewModel, input: LiveData<String>) {

//       var text by rememberSaveable { mutableStateOf("") }

        val userInput = input.observeAsState("").value

        Column(modifier = modifier.fillMaxSize()) {
//            WordsAndScore()
//            ScrambledWordTextView()
            EnterGuessTextField(onTextChange = { string -> vm.changeString(string)
            },valueEntered = userInput)
//            SkipAndSubmitButtons()
        }
    }


    @Composable
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

@Preview
@Composable
fun Preview(){

}




















