package com.example.temtemcompose.components.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.temtemcompose.models.TemTem

@Composable
fun TemTemDetailsTables(
    temTem: TemTem
) {
    BoxWithConstraints {
        if (maxWidth < 300.dp) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DisplayTraitsAndStats(temTem = temTem, 16.dp, true)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DisplayTraitsAndStats(temTem = temTem, 0.dp, false)
            }
        }
    }
}

@Composable
fun DisplayTraitsAndStats(temTem: TemTem, topPadding: Dp, fillWidth: Boolean) {
    Column(
        modifier = if (fillWidth) {
            Modifier
                .fillMaxWidth()
        } else {
            Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp)
                .width(IntrinsicSize.Max)
        }
    ) {
        temTem.traits?.let { traits ->
            repeat(traits.size + 1) {
                if (it == 0) {
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Max).fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Traits",
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),

                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                } else {
                    val trait = traits[it - 1]
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = trait,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),

                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Insert Description", modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
    Column(modifier = Modifier.padding(0.dp, topPadding, 0.dp, 16.dp)) {
        temTem.stats?.let { statMap ->
            val statList = mapOf("Stats" to "Base").plus(statMap).toList()
            repeat(statList.size) {
                val stat = statList[it]
                Row {
                    Text(
                        text = stat.first,
                        modifier = Modifier
                            .width(60.dp)
                            .border(1.dp, Color.Black, RectangleShape)
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = stat.second, modifier = Modifier
                            .width(60.dp)
                            .border(1.dp, Color.Black, RectangleShape)
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}