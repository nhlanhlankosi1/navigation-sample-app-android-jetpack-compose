package com.nhlanhlankosi.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    navigationToFirstScreen: () -> Unit,
    navigateToThirdScreen: () -> Unit,
    name: String,
    age: Int
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Welcome: $name, you are $age years old")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navigationToFirstScreen()
        }) {
            Text(text = "Go to first screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navigateToThirdScreen()
        }) {
            Text(text = "Go to third screen")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen({}, {}, "Nhlanhla", 0)
}