package com.example.todolist.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(text: String,modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().height(40.dp).background(MaterialTheme.colorScheme.primary), verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center) {
        Text(text = text, color = Color.White)
    }
}

@Preview
@Composable
private fun AppBarPrev() {
    AppBar("Lista zadań")
}