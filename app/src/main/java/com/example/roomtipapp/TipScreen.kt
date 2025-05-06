package com.example.roomtipapp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun TipScreen(viewModel: TipViewModel) {
    val tipInput by viewModel.tipInput.collectAsState()
    val tips by viewModel.tips.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = tipInput,
            onValueChange = { viewModel.onTipInputChange(it) },
            label = { Text("Ingresa la propina") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.saveTip() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Historial de propinas:")
        tips.forEach {
            Text("Propina: ${it.amount}")
        }
    }
}

