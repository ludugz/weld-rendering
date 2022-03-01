package styler.weld.rendering.models.remote

data class Item(
    val brand: String,
    val discount: Any,
    val excerpt: String,
    val id: String,
    val image: String,
    val image_url: String,
    val logo: String,
    val name: String,
    val price_with_tax: Double,
    val shop_id: String,
    val title: String,
    val type: String,
    val url: String
)