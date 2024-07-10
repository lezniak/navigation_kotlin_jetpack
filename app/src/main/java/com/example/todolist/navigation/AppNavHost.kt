package com.example.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.screens.home.HomeScreen
import com.example.todolist.screens.taskList.TaskScreen
import com.example.todolist.screens.details.DetailsScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Home.route,modifier = modifier){
        composable(route = Home.route){
            HomeScreen(onClick = {count ->
                navController.navigateToDetails(count)
            })
        }
        composable(route = List.route){
            TaskScreen()
        }
        composable(route = Notes.route){
            TaskScreen()
        }
        composable(
            route = Details.routeWithArgs,
            arguments = Details.arguments
        ) { navBackStackEntry ->
            val detailsArg =
                navBackStackEntry.arguments?.getInt(Details.detailsArg)
            DetailsScreen(detailsArg)
        }
    }
}


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

private fun NavHostController.navigateToDetails(int : Int) {
    this.navigateSingleTopTo("${Details.route}/$int")
}