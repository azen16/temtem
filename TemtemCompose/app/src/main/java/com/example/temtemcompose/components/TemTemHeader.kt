package com.example.temtemcompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.temtemcompose.TemTemServiceHelper.IMAGE_URL
import com.example.temtemcompose.TemTemViewModel

@Composable
fun TemTemHeader(viewModel: TemTemViewModel = TemTemViewModel()) {
    var showMenu by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "TemTem",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Button(onClick = { showMenu = !showMenu }, shape = RectangleShape) {
            Text("Filter")
        }
        DropdownMenu(
            expanded = showMenu,
            modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer),
            onDismissRequest = {
                showMenu = false
            })
        {
            DropdownMenuItem(text = {
                Text(
                    "Reset",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }, onClick = {
                viewModel.filter("")
                showMenu = false
            })
            viewModel.typeList.forEach {
                DropdownMenuItem(text = {
                    Text(
                        it.name ?: "",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }, leadingIcon = {
                    it.icon?.let { icon ->
                        Log.d("Icon: ", icon.substring(1, icon.length))
                        SubcomposeAsyncImage(
                            model = IMAGE_URL + icon.substring(1, icon.length),
                            contentDescription = it.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(20.dp)
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
                }, onClick = {
                    viewModel.filter(it.name ?: "")
                    showMenu = false
                })
            }
        }
    }
}