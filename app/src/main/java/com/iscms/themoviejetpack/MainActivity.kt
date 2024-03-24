package com.iscms.themoviejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.iscms.themoviejetpack.ui.theme.TheMovieJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMovieJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.hello_world)
    )
}

@Preview(showBackground = true)
@Composable
fun MediaListItem(@PreviewParameter(MediaItemParameterProvider::class) mediaItem: MediaItem) {
    Column(
        modifier = Modifier.width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
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
                        .size(92.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = mediaItem.title,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(getMedia()) { mediaItem ->
            MediaListItem(mediaItem)
        }
    }
}

//@Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
fun ButtonText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            fontSize = 25.sp,
            text = stringResource(id = R.string.lorem),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.LineThrough,
            lineHeight = 2.em,
            maxLines = 1,
            onTextLayout = {},
            style = MaterialTheme.typography.headlineLarge.copy(
                shadow = Shadow(
                    offset = Offset(10f, 10f),
                    blurRadius = 10f
                )
            )
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheMovieJetpackTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Greeting(
                name = "Android", modifier = Modifier
                    .background(Color.Gray)
                    .weight(2f)
            )
            Greeting(
                name = "Antonio", modifier = Modifier
                    .background(Color.Blue)
                    .weight(2f)
            )
            Greeting(
                name = "Ivan", modifier = Modifier
                    .background(Color.Cyan)
                    .weight(3f)
            )
        }
    }
}