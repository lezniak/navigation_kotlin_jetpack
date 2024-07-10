package com.example.todolist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface AppDestionation {
    val icon : ImageVector
    val route : String
}

data object List : AppDestionation{
    override val icon: ImageVector
        get() = Icons.Default.List
    override val route: String
        get() = "list"

}

data object Home : AppDestionation{
    override val icon: ImageVector
        get() = Icons.Default.Home
    override val route: String
        get() = "home"
}

data object Notes : AppDestionation{
    override val icon: ImageVector
        get() = Icons.Default.NoteAlt
    override val route: String
        get() = "notes"
}

val tabListScreens = listOf(Home,List,Notes)