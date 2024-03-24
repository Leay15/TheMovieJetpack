package com.iscms.themoviejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.iscms.themoviejetpack.ui.screen.home.HomeScreen
import com.iscms.themoviejetpack.ui.TheMovieApp
import com.iscms.themoviejetpack.ui.theme.TheMovieJetpackTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMovieApp {
                HomeScreen()
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

//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun StateExample(value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            modifier = Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(text = "Clear")
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