package com.learningwithmanos.uniexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learningwithmanos.uniexercise.heroes.ui.HeroesScreen
import com.learningwithmanos.uniexercise.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPref.setup(applicationContext)

        appPref.apikey = "d117e3f0cef58a87791767d25a5ab3c2"


        setContent {
            MyApplicationTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Heroes"
                ) {

                    composable("Heroes") {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            HeroesScreen(onIconButtonPressed = { navController.navigate("Api") })
                        }
                    }
                }
            }
        }
    }
}