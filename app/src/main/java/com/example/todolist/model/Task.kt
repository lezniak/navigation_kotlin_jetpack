package com.example.todolist.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(val title : String,val description : String,isExtended : Boolean){
    var isExtended by mutableStateOf(isExtended)
}
