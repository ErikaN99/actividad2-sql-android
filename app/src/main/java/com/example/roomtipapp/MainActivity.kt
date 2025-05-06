package com.example.roomtipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomtipapp.ui.theme.RoomTipAppTheme
import android.content.Context

class MainActivity : ComponentActivity() {

    private lateinit var tipViewModel: TipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tipViewModel = TipViewModel(TipDatabase.getDatabase(this@MainActivity).tipDao())
        tipViewModel.loadTips()

        setContent {
            RoomTipAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipScreen(viewModel = tipViewModel)
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomTipAppTheme {
        Greeting("Android")
    }
}