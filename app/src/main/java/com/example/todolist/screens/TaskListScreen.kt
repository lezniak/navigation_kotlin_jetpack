package com.example.todolist.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.model.Task

@Composable
fun TaskScreen(modifier: Modifier = Modifier) {
    
}

@Composable
fun TaskCard(modifier: Modifier = Modifier,
             title: String,
             createDate: String,
             description: String,
             isExtended : Boolean,
             onExtendedChange : (Boolean) -> Unit) {

    Card(modifier = modifier
        .fillMaxWidth()
        .padding(2.dp)) {

        Column(
            modifier
                .fillMaxWidth()
                .padding(4.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = title)
                IconButton(onClick = { onExtendedChange(!isExtended) }) {
                    Image(imageVector = if (!isExtended) Icons.Default.ExpandMore else Icons.Default.ExpandLess, contentDescription = null)
                }

            }
            if (isExtended){
                HorizontalDivider(color = Color.Black, thickness = 1.dp)
                Text(text = createDate)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = description)
            }

        }


    }
}

@Composable
fun TaskList(modifier: Modifier = Modifier) {
    val array = ArrayList<Task>()
    for (i in 0..10){
        array.add(Task(i.toString(),i.toString(), rememberSaveable {
            mutableStateOf(false)
        }))
    }

    LazyColumn {
        items(items = array) { item ->
            TaskCard(title = item.title, createDate = "2024.07.09 19:43", description = item.description, onExtendedChange = { bool -> item.isExtended.value = bool}, isExtended = item.isExtended.value)
        }
    }
}
@Preview
@Composable
private fun TaskCardPreview() {
    TaskList()
}