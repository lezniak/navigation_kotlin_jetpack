package com.example.todolist.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class CounterItem(count: Int, val color: Color) {
    var count by mutableIntStateOf(count)
}