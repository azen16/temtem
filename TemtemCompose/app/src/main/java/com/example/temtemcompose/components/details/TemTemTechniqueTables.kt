package com.example.temtemcompose.components.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.temtemcompose.TemTemServiceHelper
import com.example.temtemcompose.TemTemViewModel
import com.example.temtemcompose.models.TemTem

@Composable
fun TemTemTechniqueTables(
    temTem: TemTem,
    viewModel: TemTemViewModel
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        temTem.techniques?.let { techniques ->
            val levelList = techniques.filter { it.source == "Levelling" }
            BoxWithConstraints {
                if (maxWidth < 800.dp) {
                    Row {
                        Text(
                            text = "Level",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Technique",
                            modifier = Modifier
                                .weight(3f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Class",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                } else {
                    Row {
                        Text(
                            text = "Level",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Technique",
                            modifier = Modifier
                                .weight(3f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Type",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Class",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Damage",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "STA",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Hold",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Priority",
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Black, RectangleShape)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            levelList.forEach {
                val info = viewModel.findTechnique(it.name)
                BoxWithConstraints {
                    if (maxWidth < 800.dp) {
                        Row(modifier = Modifier.height(IntrinsicSize.Max)) {
                            Text(
                                text = it.levels ?: it.source ?: "",
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = it.name ?: "",
                                modifier = Modifier
                                    .weight(3f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                info?.classIcon?.let { icon ->
                                    SubcomposeAsyncImage(
                                        model = TemTemServiceHelper.IMAGE_URL + icon.substring(
                                            1,
                                            icon.length
                                        ),
                                        contentDescription = "${it.name} type",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(
                                                CircleShape
                                            )
                                    ) {
                                        val state = painter.state
                                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                            CircularProgressIndicator()
                                        } else {
                                            SubcomposeAsyncImageContent()
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Row(modifier = Modifier.height(IntrinsicSize.Max), verticalAlignment = Alignment.CenterVertically ) {
                            Text(
                                text = it.levels ?: it.source ?: "",
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = it.name ?: "",
                                modifier = Modifier
                                    .weight(3f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                viewModel.findTypeIcon(info?.type ?: "")?.let { icon ->
                                    SubcomposeAsyncImage(
                                        model = TemTemServiceHelper.IMAGE_URL + icon.substring(
                                            1,
                                            icon.length
                                        ),
                                        contentDescription = "${it.name} type",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(
                                                CircleShape
                                            )
                                    ) {
                                        val state = painter.state
                                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                            CircularProgressIndicator()
                                        } else {
                                            SubcomposeAsyncImageContent()
                                        }
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                info?.classIcon?.let { icon ->
                                    SubcomposeAsyncImage(
                                        model = TemTemServiceHelper.IMAGE_URL + icon.substring(
                                            1,
                                            icon.length
                                        ),
                                        contentDescription = "${it.name} class",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(
                                                CircleShape
                                            )
                                    ) {
                                        val state = painter.state
                                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                            CircularProgressIndicator()
                                        } else {
                                            SubcomposeAsyncImageContent()
                                        }
                                    }
                                }
                            }
                            Text(
                                text = if (info?.damage != null && info.damage > 0) info.damage.toString() else "-",
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = info?.staminaCost?.toString() ?: "-",
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = info?.hold?.toString() ?: "-",
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(1.dp, Color.Black, RectangleShape),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                info?.priorityIcon?.let { icon ->
                                    SubcomposeAsyncImage(
                                        model = TemTemServiceHelper.IMAGE_URL + icon.substring(
                                            1,
                                            icon.length
                                        ),
                                        contentDescription = "${it.name} class",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .size(40.dp)
                                    ) {
                                        val state = painter.state
                                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                            CircularProgressIndicator()
                                        } else {
                                            SubcomposeAsyncImageContent()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}