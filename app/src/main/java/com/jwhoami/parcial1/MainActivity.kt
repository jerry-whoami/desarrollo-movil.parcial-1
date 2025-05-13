package com.jwhoami.parcial1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx. compose. runtime.getValue
import androidx. compose. runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jwhoami.parcial1.ui.theme.Parcial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                ValidationView()
            }
        }
    }
}

@Composable
fun ValidationView() {
    var context = LocalContext.current
    var score by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(32.dp)
            .background(Color(0xf3f4f6)),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Parcial #1",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "Jeremiah Kurmaty, 8-1004-172",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            "Daniel Maestre, 8-1005-1509",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("Ingrese la nota a validar", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = score,
            onValueChange = { score = it },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button (
            onClick = {
                val input = score.toIntOrNull()

                if (input == null) {
                    Toast.makeText(context, "Por favor ingrese una nota valida", Toast.LENGTH_SHORT).show()
                } else if (input !in 0..100) {
                    Toast.makeText(context, "La nota debe estar entre 0 y 100", Toast.LENGTH_SHORT).show()
                } else if (input > 90) {
                    Toast.makeText(context, "A - Excelente", Toast.LENGTH_SHORT).show()
                } else if (input > 80) {
                    Toast.makeText(context, "B - Bueno", Toast.LENGTH_LONG).show()
                } else if (input > 70) {
                    Toast.makeText(context, "C - Regular", Toast.LENGTH_SHORT).show()
                } else if (input > 60) {
                    Toast.makeText(context, "D - Mas o menos regular", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "F - No aprobado", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Validar"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ValidationViewPreview() {
    MaterialTheme {
        ValidationView()
    }
}