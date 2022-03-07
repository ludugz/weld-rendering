package styler.weld.rendering.models.local.itemlist

import styler.weld.rendering.models.local.HorizontalItem

data class ItemListItem(
    val brand: String,
    val discount: Any?,
    val id: String,
    val image: String,
    val name: String,
    val price_with_tax: Double?,
    val shop_id: String,
    val type: String
) : HorizontalItem