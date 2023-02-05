package com.example.temtemcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.temtemcompose.R
import com.example.temtemcompose.models.TemTem

@Composable
fun TemTemListItem(
    temTem: TemTem,
    clickAction: () -> Unit
) {

    Column(modifier = Modifier.padding(16.dp).clickable{clickAction()}) {

        SubcomposeAsyncImage(
            model = temTem.portrait, contentDescription = temTem.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
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
        Text(text = temTem.name ?: "", Modifier.padding(16.dp), color = MaterialTheme.colorScheme.primary)
    }
}

@Preview
@Composable
fun PreviewTemTemListItem() {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(
                    CircleShape
                )
                .border(2.dp, Color.Cyan, CircleShape)
        )
        Text(text = "Momo", Modifier.padding(16.dp), color = MaterialTheme.colorScheme.primary)
    }
}