package com.example.temtemcompose.components.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.temtemcompose.TemTemViewModel

@Composable
fun TemTemComposable(
    viewModel: TemTemViewModel,
    id: Int?
) {
    id?.let {
        viewModel.selectTemTem(it)
    }
    viewModel.currentTem.value?.let { temTem ->
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                SubcomposeAsyncImage(
                    model = temTem.portrait, contentDescription = temTem.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(
                            CircleShape
                        )
                        .border(2.dp, Color.Cyan, CircleShape)
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator()
                    } else {
                        SubcomposeAsyncImageContent()
                    }

                }
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = temTem.name ?: "",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = temTem.types?.joinToString(" | ") ?: "",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(0.dp, 16.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
                text = temTem.description ?: "",
                fontStyle = FontStyle.Italic
            )
            LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                temTem.stats?.let { statMap ->
                    items(mapOf("Stat" to "Base").plus(statMap).toList()) {
                        Row {
                            Text(
                                text = it.first,
                                modifier = Modifier
                                    .width(70.dp)
                                    .border(1.dp, Color.Black, RectangleShape)
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = it.second, modifier = Modifier
                                    .width(70.dp)
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