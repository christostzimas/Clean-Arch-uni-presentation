package com.learningwithmanos.uniexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learningwithmanos.uniexercise.heroes.ui.HeroesScreen
import com.learningwithmanos.uniexercise.settings.ui.SettingsScreen
import com.learningwithmanos.uniexercise.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Modifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = { AppTopBar(navController) },
                    bottomBar = { AppBottomNavigationBar(navController) }
                ) { innerPadding ->
                    AppNavGraph(navController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text("Marvel App") },
        actions = {
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings"
                )
            }
        }
    )
}

@Composable
fun AppBottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Heroes,
        BottomNavItem.Query,
        BottomNavItem.Quiz
    )

    BottomNavigation {
        val currentRoute = navController.currentDestination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: ImageVector, var route: String) {
    object Heroes : BottomNavItem("Heroes", ImageVector.vectorResource(id = R.drawable.ic_heroes), "heroes")
    object Query : BottomNavItem("Query", ImageVector.vectorResource(id = R.drawable.ic_query), "query")
    object Quiz : BottomNavItem("Quiz", ImageVector.vectorResource(id = R.drawable.ic_quiz), "quiz")
}

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Heroes.route, modifier = modifier) {
        composable(BottomNavItem.Heroes.route) { HeroesScreen(navController) }
        composable(BottomNavItem.Query.route) { QueryScreen(navController) }
        composable(BottomNavItem.Quiz.route) { QuizScreen(navController) }
        composable("heroDetails/{heroId}") { backStackEntry ->
            HeroDetailsScreen(navController, backStackEntry.arguments?.getString("heroId"))
        }
        composable("settings") { SettingsScreen(navController) }
    }
}

@Composable
fun QueryScreen(navController: NavHostController) {
    Text(text = "Query Screen")
}

@Composable
fun QuizScreen(navController: NavHostController) {
    Text(text = "Quiz Screen")
}

@Composable
fun HeroDetailsScreen(navController: NavHostController, heroId: String?) {
    Text(text = "Hero Details Screen")
}
