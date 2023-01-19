package com.example.unscramblecomposefromscratch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData

class MainScreen() {

    @Composable
    fun Screen(
        modifier: Modifier = Modifier.padding(12.dp),
        vm: ViewModel,
        userGuess: LiveData<String>
    ) {
        val userInput = userGuess.observeAsState("").value

        Column(modifier = modifier.fillMaxSize()) {
//            WordsAndScore()
//            ScrambledWordTextView()
            SkipAndSubmitButtons(
                modifier = modifier,
                numOfTriesLeft = vm.numOfTriesLeft,
                score = vm.score
            )
            EnterGuessTextField(onTextChange = { string ->
                vm.updateUserInput(string)
            }, valueEntered = userInput)
        }
    }


    @Composable
    fun EnterGuessTextField(
        onTextChange: (String) -> Unit,
        valueEntered: String,
    ) {
        OutlinedTextField(
            value = valueEntered,
            onValueChange = onTextChange,
            isError = false,
            label = { Text(text = "input") },
            singleLine = true
        )
    }

    @Composable
    fun SkipAndSubmitButtons(
        modifier: Modifier = Modifier,
        numOfTriesLeft: LiveData<Int>,
        score: LiveData<Int>
    ) {

        Row(modifier = modifier) {
            Text(
                text = "${numOfTriesLeft.value} of 10 words",
                style = MaterialTheme.typography.subtitle1,

                )
            Text(
                text = "Score: ${score.value}",
                style = MaterialTheme.typography.subtitle1
            )
        }
    }

    private @Composable
    fun ScrambledWordTextView() {

    }

    private @Composable
    fun WordsAndScore() {
        TODO("Not yet implemented")
    }

}

@Preview
@Composable
fun Preview() {

}




















