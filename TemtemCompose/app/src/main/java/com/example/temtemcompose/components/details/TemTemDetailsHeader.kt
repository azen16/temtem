package com.example.temtemcompose.components.details

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.temtemcompose.models.TemTem

@Composable
fun TemTemDetailsHeader(
    temTem: TemTem,
    navController: NavController
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SubcomposeAsyncImage(
            model = temTem.portrait, contentDescription = temTem.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(
                    CircleShape
                )
                .border(2.dp, MaterialTheme.colorScheme.tertiary, CircleShape)
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
                style = MaterialTheme.typography.displaySmall,
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
    temTem.number?.let { id ->
        Row(
            modifier = Modifier.fillMaxWidth().padding(0.dp, 16.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Previous TemTem",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {

                    navController.navigate("temtem/${id - 1}") {
                        popUpTo("home")
                    }
                })
            if (temTem.number != 164) {
                Text(
                    textAlign = TextAlign.End,
                    text = "Next TemTem",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.clickable {
                        navController.navigate("temtem/${id + 1}") {
                            popUpTo("home")
                        }
                    })
            }
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
}