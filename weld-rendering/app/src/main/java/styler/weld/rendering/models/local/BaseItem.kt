package styler.weld.rendering.models.local

open class BaseItem(
    open val brand: String? = null,
    open val discount: Any? = null,
    open val id: String? = null,
    open val image: String? = null,
    open val name: String? = null,
    open val price_with_tax: Double? = null,
    open val shop_id: String? = null,
    open val type: String? = null,
    open val logo: String? = null,
    open val image_url: String? = null,
    open val url: String? = null,
    open val title: String? = null,
    open val excerpt: String? = null
)