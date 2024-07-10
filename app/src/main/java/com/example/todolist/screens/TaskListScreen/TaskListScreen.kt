package com.example.todolist.screens.TaskListScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.model.Task

@Composable
fun TaskScreen(modifier: Modifier = Modifier) {
    TaskList(modifier = modifier)
}

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onClear: (Task) -> Unit,
    onExtendedChange: (Boolean) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        with(task) {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = title)
                    Row() {
                        IconButton(onClick = { onExtendedChange(!task.isExtended) }) {
                            Image(
                                imageVector = if (task.isExtended) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = { onClear(task) }) {
                            Image(imageVector = Icons.Default.Clear, contentDescription = null)
                        }
                    }

                }
                if (task.isExtended) {
                    HorizontalDivider(color = Color.Black, thickness = 1.dp)
                    Text(text = "1999.20.20")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = description)
                }

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskList(modifier: Modifier = Modifier) {
    val array = remember {
        mutableStateListOf<Task>().apply {
            for (i in 0..10) {
                add(Task(i.toString(), i.toString(), false))
            }
        }
    }

    LazyColumn {
        items(items = array) { item ->
            TaskCard(
                modifier = Modifier.animateItemPlacement(),
                task = item,
                onExtendedChange = { bool -> item.isExtended = bool },
                onClear = {
                    array.remove(item)
                })
        }
    }
}

@Preview
@Composable
private fun TaskCardPreview() {
    TaskList()
}