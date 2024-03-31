package com.iscms.themoviejetpack.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iscms.themoviejetpack.R
import com.iscms.themoviejetpack.model.getMedia
import com.iscms.themoviejetpack.ui.items.MediaListItem

@Preview(showBackground = true)
@Composable
fun MediaList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.cell_space_arrangement)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.cell_space_arrangement)),
        modifier = modifier
    ) {
        items(getMedia()) { mediaItem ->
            MediaListItem(mediaItem)
        }
    }
}