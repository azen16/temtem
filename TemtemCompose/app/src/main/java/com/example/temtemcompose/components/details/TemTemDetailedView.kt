package com.example.temtemcompose.components.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.temtemcompose.TemTemViewModel

@Composable
fun TemTemDetailedView(
    viewModel: TemTemViewModel,
    id: Int?,
    navController: NavHostController
) {
    val detailedViewList = arrayListOf("Header", "Tables")
    id?.let {
        viewModel.selectTemTem(it)
    }
    viewModel.currentTem.value?.let { temTem ->
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(detailedViewList) {
                when (it) {
                    "Header" -> TemTemDetailsHeader(
                        temTem = temTem,
                        viewModel = viewModel,
                        navController = navController
                    )
                    "Tables" ->  {
                        TemTemDetailsTables(temTem = temTem)
                        TemTemTechniqueTables(temTem = temTem, viewModel = viewModel)
                    }
                }
            }
        }
    } ?: run {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}