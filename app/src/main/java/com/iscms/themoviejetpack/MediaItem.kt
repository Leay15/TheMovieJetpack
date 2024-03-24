package com.iscms.themoviejetpack

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    sealed class Type {

        object PHOTO : Type()
        object VIDEO : Type()
    }
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://dummyimage.com/600x400/000/fff.jpg&text=$it",
        type = if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}
