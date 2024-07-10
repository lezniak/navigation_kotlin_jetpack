package com.example.todolist.screens.HomeScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.model.CounterItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeGrid(modifier)
}

@Composable
private fun HomeGrid(modifier: Modifier = Modifier) {
    val items = remember {
        mutableStateListOf<CounterItem>().apply {
            addAll(listOf(CounterItem(0,Color.Green), CounterItem(0,Color.Red), CounterItem(0,Color.Black), CounterItem(0,Color.Blue)))
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // liczba kolumn
        modifier = Modifier.fillMaxSize(),
        contentPadding =PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            SquareBox(item.color, onClick = { item.count++ },item.count)
        }
    }
}

@Composable
fun SquareBox(color: Color, onClick : () -> Unit, count: Int) {
    Box(
        modifier = Modifier
            .size(height = 100.dp+count.dp, width = 100.dp)
            .background(color)
            .padding(16.dp)
            .clickable {
                onClick()
            }
    ){
        Text(text = "CZESC $count", color = Color.White)
    }
}

@Preview
@Composable
private fun Prewiew() {
    HomeGrid()
}