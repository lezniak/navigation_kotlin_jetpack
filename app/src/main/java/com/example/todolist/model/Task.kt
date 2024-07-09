package com.example.todolist.model

import androidx.compose.runtime.MutableState

data class Task(val title : String,val description : String,var isExtended : MutableState<Boolean>)
