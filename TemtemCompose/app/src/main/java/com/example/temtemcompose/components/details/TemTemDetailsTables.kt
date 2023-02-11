package com.example.temtemcompose.components.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.temtemcompose.models.TemTem

@Composable
fun TemTemDetailsTables(
    temTem: TemTem
) {
    Column {
        Row {
            Column(modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp)) {
                temTem.traits?.let { traits ->
                    repeat(traits.size + 1) {
                        if (it == 0) {
                            Row(
                                modifier = Modifier.height(IntrinsicSize.Max),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Traits",
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(200.dp)
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
                                        .width(100.dp)
                                        .border(1.dp, Color.Black, RectangleShape)
                                        .padding(8.dp),

                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "Insert Description", modifier = Modifier
                                        .width(100.dp)
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
            Column {
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
        Row(modifier = Modifier.padding(16.dp)) {

        }
        temTem.techniques?.let { techniques ->
            repeat(techniques.size + 1) {
                if (it == 0) {
                    Row {
                        Row {
                            Text(
                                text = "Technique",
                                modifier = Modifier
                                    .width(200.dp)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "How to Acquire",
                                modifier = Modifier
                                    .width(200.dp)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                } else {
                    val technique = techniques[it - 1]
                    Row {
                        Row {
                            Text(
                                text = technique.name ?: "",
                                modifier = Modifier
                                    .width(200.dp)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = if (technique.levels != null) {
                                    "Level ${technique.levels}"
                                } else {
                                    technique.source ?: ""
                                },
                                modifier = Modifier
                                    .width(200.dp)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}