package com.iscms.themoviejetpack.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iscms.themoviejetpack.R

@Preview(showBackground = true, widthDp = 160, heightDp = 300)
@Composable
fun MovieItemCard() {
    Card(
        modifier = Modifier
            .width(160.dp)
            .wrapContentHeight()
            .padding(15.dp), // Asigna una elevación predeterminada si deseas simular la sombra de un CardView
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "poster",
                modifier = Modifier
                    .width(120.dp)
                    .height(170.dp)
                    .padding(5.dp)
            )
            Text(
                text = "title",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "popularity",
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
