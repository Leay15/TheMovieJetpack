package com.iscms.themoviejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
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
                    Greeting("Android")
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

//@Preview(showBackground = true)
@Composable
fun MediaItem() {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.Red)
                .align(Alignment.CenterHorizontally)
        ) {

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Title 1")
        }
    }
}


@Preview(showBackground = true, widthDp = 400, heightDp = 200)
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
            lineHeight = 2.em
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