package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todolist.common.AppBar
import com.example.todolist.common.AppTabRow
import com.example.todolist.navigation.AppNavHost
import com.example.todolist.navigation.Home
import com.example.todolist.navigation.navigateSingleTopTo
import com.example.todolist.navigation.tabListScreens
import com.example.todolist.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen =
        tabListScreens.find { it.route == currentDestination?.route } ?: Home

    Scaffold(
        topBar =  {

        },
        bottomBar = {
            AppTabRow(allScreens = tabListScreens, onTabSelected = { screen -> navController.navigateSingleTopTo(screen.route)},currentScreen = currentScreen)
        }
    ) { innerPadding ->
        AppNavHost(navController = navController,Modifier.padding(innerPadding))
    }
}
