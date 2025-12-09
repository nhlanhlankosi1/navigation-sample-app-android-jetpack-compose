package com.nhlanhlankosi.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nhlanhlankosi.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable(
            "secondscreen/{name}/{age}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "No name"
                },
                navArgument("age") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )) {

            val name = it.arguments?.getString("name") ?: "No name received"
            val age = it.arguments?.getInt("age") ?: 0

            SecondScreen({
                navController.navigate("firstscreen")
            }, {
                navController.navigate("thirdscreen")
            }, name, age)
        }
        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }

}

