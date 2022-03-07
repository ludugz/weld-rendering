package styler.weld.rendering.models.remote

open class BaseItem(
    open val brand: String = "",
    open val discount: Any? = null,
    open val id: String = "",
    open val image: String = "",
    open val name: String = "",
    open val price_with_tax: Double? = null,
    open val shop_id: String = "",
    open val type: String = "",
    open val logo: String = "",
    open val image_url: String? = null,
    open val url: String? = null,
    open val title: String? = null,
    open val excerpt: String? = null
)