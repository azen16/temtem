package com.example.temtemcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.temtemcompose.components.PreviewTemTemListItem

import com.example.temtemcompose.components.TemTemHeader
import com.example.temtemcompose.components.TemTemListItem
import com.example.temtemcompose.components.details.TemTemComposable
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
                    TemNavHostContainer()
                }
            }
        }
    }

    @Composable
    fun TemNavHostContainer() {
        val viewModel = remember {TemTemViewModel()}
        val navController = rememberNavController()

        NavHost(navController, startDestination = "home") {
            composable("home") {
                TemGrid(viewModel = viewModel, navController)
            }
            composable("temtem/{id}",
             arguments = listOf(navArgument("id") {type = NavType.IntType})) {
                TemTemComposable(viewModel = viewModel, it.arguments?.getInt("id"))
            }
        }
    }

    @Composable
    fun TemGrid(
        viewModel: TemTemViewModel,
        navController: NavController
    ) {
        Column {
            TemTemHeader(viewModel)
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                items(viewModel.filteredTemList) {
                    TemTemListItem(temTem = it) {
                        it.number?.let { id ->
                            navController.navigate("temtem/$id")
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun TemGridPreview() {
        Column {
            TemTemHeader()
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                items(listOf(1, 2, 3, 4, 5)) {
                    PreviewTemTemListItem()
                }
            }
        }
    }
}
