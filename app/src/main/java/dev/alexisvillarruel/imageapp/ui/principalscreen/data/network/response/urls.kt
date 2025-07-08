package dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response

data class urlsUnsp(
    val id: String,
    var urls: Urlsplashphotos2,
)

data class Urlsplashphotos2(
    val regular: String,
)

//data class de rsponse de ilters
data class searchResponse(
    val results: List<Item>,
)

data class Item(
    val urls: Urls,
    val links: Links
)

data class Urls(
    val regular: String
)

data class Links(
    val download: String
)