package styler.weld.rendering.utils

fun imageFromId(imageId: String): String {
    return "https://api.stg.facy.jp/images/$imageId/original.jpeg"
}

fun formattedPrice(price: Double?): String {
    return "¥$price (税込)"
}
