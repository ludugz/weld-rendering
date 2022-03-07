package styler.weld.rendering.models.remote

import styler.weld.rendering.models.remote.BaseItem

open class Data(
    open val image_id: String? = null,
    open val target: String? = null,
    open val items: List<BaseItem>? = null,
)