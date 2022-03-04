package styler.weld.rendering.models.local

import styler.weld.rendering.models.local.itemlist.ItemListItem

open class BaseData(
    // banner
    open val image_id: String? = null,
    open val target: String? = null,
    // item list
    open val items: List<ItemListItem>? = null
) : Any()