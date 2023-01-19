package com.example.unscramblecomposefromscratch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.unscramblecomposefromscratch.ui.MainScreen
import com.example.unscramblecomposefromscratch.ui.ViewModel
import com.example.unscramblecomposefromscratch.ui.theme.UnscrambleComposeFromScratchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ;val vm = ViewModelProvider(this).get(ViewModel::class.java)

                MainScreen().Screen(vm = vm , input = vm.userInput)
        }
    }
}

