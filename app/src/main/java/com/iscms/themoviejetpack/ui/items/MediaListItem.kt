package com.iscms.themoviejetpack.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.iscms.themoviejetpack.model.MediaItem
import com.iscms.themoviejetpack.model.MediaItemParameterProvider
import com.iscms.themoviejetpack.R

@Preview(showBackground = true)
@Composable
fun MediaListItem(@PreviewParameter(MediaItemParameterProvider::class) mediaItem: MediaItem) {
    Column(
        modifier = Modifier.width(dimensionResource(id = R.dimen.media_list_column_width))
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.media_list_item_height))
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .crossfade(true)
                    .data(mediaItem.thumb)
                    .error(R.drawable.ic_launcher_foreground)
                    .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (mediaItem.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(dimensionResource(id = R.dimen.media_list_item_video_icon_size))
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(dimensionResource(id = R.dimen.media_list_item_title_padding)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = mediaItem.title,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
