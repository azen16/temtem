package com.example.temtemcompose.components.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.temtemcompose.TemTemViewModel

@Composable
fun TemTemDetailedView(
    viewModel: TemTemViewModel,
    id: Int?
) {
    val detailedViewList = arrayListOf("Header", "Tables")
    id?.let {
        viewModel.selectTemTem(it)
    }
    viewModel.currentTem.value?.let { temTem ->
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(detailedViewList) {
                when (it) {
                    "Header" -> TemTemDetailsHeader(temTem = temTem)
                    "Tables" -> TemTemDetailsTables(temTem = temTem)
                }
            }
        }
    }
}