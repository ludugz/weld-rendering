package styler.weld.rendering.models.local

import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.local.shoplist.ShopListItem

open class BaseData(
    // banner
    open val image_id: String? = null,
    open val target: String? = null,

    // item list
    open val items: List<ItemListItem>? = null,

    // shop list
    open val shops: List<ShopListItem>? = null,

    // article List
    open val image_url: String? = null,
    open val url: String? = null,
    open val title: String? = null,
    open val excerpt: String? = null,
) : Any()