package styler.weld.rendering.models.local

open class BaseData(
    open val image_id: String? = null,
    open val target: String? = null,
    open val items: List<BaseItem>? = null,
)