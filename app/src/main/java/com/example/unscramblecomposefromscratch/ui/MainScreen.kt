package com.example.unscramblecomposefromscratch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData

class MainScreen() {

    @Composable
    fun Screen(
        modifier: Modifier = Modifier.padding(12.dp),
        vm: ViewModel,
        userGuess: LiveData<String>,
        nextWord: LiveData<String>
    ) {
        val userInput = userGuess.observeAsState("").value
        val nextScrambledWord = nextWord.observeAsState("").value


        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WordsAndScore(
                modifier = modifier, numOfTriesLeft = vm.numOfTriesLeft, score = vm.score
            )
            ScrambledWordTextView(
                scrambledWord = nextScrambledWord, modifier = modifier.padding(top = 40.dp)
            )

            EnterGuessTextField(
                onTextChange = { string ->
                    vm.updateUserInput(string)
                }, valueEntered = userInput, isError = requireNotNull(vm.isError.value)
            )

            SkipAndSubmitButtons(
                nextWord = { vm.skipWord() },
                submitGuess = { vm.checkGuess() }
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
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp),
            label = { if (isError) Text(text = "wrong guess") else Text(text = "enter your guess") },
            singleLine = true
        )
    }

    @Composable
    fun WordsAndScore(
        modifier: Modifier = Modifier, numOfTriesLeft: LiveData<Int>, score: LiveData<Int>
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
                text = "Score: ${score.value}", style = MaterialTheme.typography.subtitle1
            )
        }
    }

    @Composable
    fun ScrambledWordTextView(modifier: Modifier = Modifier, scrambledWord: String) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        ) {
            Text(
                text = scrambledWord,
                modifier = Modifier.padding(bottom = 20.dp),
                style = MaterialTheme.typography.h3
            )
            Text(
                text = "Unscramble the word", fontSize = 20.sp
            )
        }
    }

    @Composable
    fun SkipAndSubmitButtons(
        modifier: Modifier = Modifier,
        nextWord: () -> Unit,
        submitGuess: () -> Unit,
    ) {

        Row(
            modifier = modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                onClick = { nextWord() },
                enabled = true,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = CircleShape

            ) { Text("Next") }
            Button(
                onClick = { submitGuess() },
                enabled = true,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = CircleShape
            ) {
                Text("Submit")

            }
        }
    }
}



















