package com.example.temtemcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.temtemcompose.TemTemViewModel

@Composable
fun TemTemHeader(viewModel: TemTemViewModel = TemTemViewModel()) {
    var showMenu by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(
                "TemTem",
                Modifier.padding(10.dp),
                Color.Green,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
        }
        Button(onClick = { showMenu = !showMenu }, shape = RectangleShape) {
            Text("Filter by")
        }
        DropdownMenu(expanded = showMenu, onDismissRequest = {
            showMenu = false
        }) {
            DropdownMenuItem(text = { Text("Reset")}, onClick = {
                viewModel.filter("")
                showMenu = false
            })
            viewModel.typeList.forEach {
                DropdownMenuItem(text = { Text(it.name ?: "") }, onClick = {
                    viewModel.filter(it.name ?: "")
                    showMenu = false
                })
            }
        }
    }
}