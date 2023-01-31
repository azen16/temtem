package com.example.temtemcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope

import com.example.temtemcompose.components.TemTemHeader
import com.example.temtemcompose.models.TemTem
import com.example.temtemcompose.ui.theme.TemtemComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemtemComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    TemGrid()
                }
            }
        }
    }
    @Composable
    fun TemGrid(
        viewModel: TemTemViewModel = TemTemViewModel()
    ) {
        Column {
            TemTemHeader()
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                items(viewModel.temList) {
                    TemTemHeader(temTem = it)
                }
            }
        }
    }
}
