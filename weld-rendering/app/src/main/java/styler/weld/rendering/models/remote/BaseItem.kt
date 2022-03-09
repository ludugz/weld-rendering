package styler.weld.rendering.models.remote

// TODO: This can be deleted later 
open class BaseItem(
    val brand: String = "",
    val discount: Any? = null,
    val id: String = "",
    val image: String = "",
    val name: String = "",
    val price_with_tax: Double? = null,
    val shop_id: String = "",
    val type: String = "",
    val logo: String = "",
    val image_url: String? = null,
    val url: String? = null,
    val title: String? = null,
    val excerpt: String? = null
)