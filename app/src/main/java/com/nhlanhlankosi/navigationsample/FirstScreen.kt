package com.nhlanhlankosi.navigationsample

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigationToSecondScreen: (String, Int) -> Unit) {

    val name = remember {
        mutableStateOf("")
    }

    val age = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = name.value, placeholder = {
            Text(text = "Enter your name")
        }, onValueChange = {
            name.value = it
        })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = age.value, placeholder = {
            Text(text = "Enter your age")
        }, onValueChange = {
            // allow only digits
            if (it.all { char -> char.isDigit() }) {
                age.value = it
            }
        })
        Spacer(modifier = Modifier.height(8.dp))
        val context = LocalContext.current
        Button(onClick = {
            val ageInt = age.value.toIntOrNull()
            if (name.value.isNotBlank() && ageInt != null) {
                navigationToSecondScreen(name.value, ageInt)
            } else {
                //Show toast here
                Toast.makeText(context, "Please enter a name and age", Toast.LENGTH_SHORT).show()
            }

        }) {
            Text(text = "Go to second screen")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen({ name, age ->
    })
}