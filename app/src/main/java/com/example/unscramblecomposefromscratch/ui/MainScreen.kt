package com.example.unscramblecomposefromscratch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            WordsAndScore()
//            ScrambledWordTextView()
            WordsAndScore(
                modifier = modifier,
                numOfTriesLeft = vm.numOfTriesLeft,
                score = vm.score
            )
            EnterGuessTextField(
                onTextChange = { string ->
                    vm.updateUserInput(string)
                },
                valueEntered = userInput,
                isError = requireNotNull(vm.isError.value)
            )
        }
    }


    @Composable
    fun EnterGuessTextField(
        onTextChange: (String) -> Unit,
        valueEntered: String,
        modifier: Modifier = Modifier,
        isError: Boolean
    ) {
        OutlinedTextField(
            value = valueEntered,
            onValueChange = onTextChange,
            isError = isError,
            label = { if (isError) Text(text = "wrong guess") else Text(text = "enter your guess") },
            singleLine = true
        )
    }

    @Composable
    fun WordsAndScore(
        modifier: Modifier = Modifier,
        numOfTriesLeft: LiveData<Int>,
        score: LiveData<Int>
    ) {

        Row(
            modifier = modifier
        ) {
            Text(
                text = "${numOfTriesLeft.value} of 10 words",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.weight(1f)
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
    fun SkipAndSubmitButtons() {
        TODO("Not yet implemented")
    }

}

@Preview
@Composable
fun Preview() {

}




















