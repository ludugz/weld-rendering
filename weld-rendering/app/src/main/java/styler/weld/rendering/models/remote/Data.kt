package styler.weld.rendering.models.remote

data class Data(
    val image_id: String,
    val items: List<Item>,
    val target: String
)