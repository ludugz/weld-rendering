package styler.weld.rendering.models.local.shoplist

import styler.weld.rendering.models.local.HorizontalListItem

data class ShopListItem(
    val id: String,
    val name: String,
    val logo: String
) : HorizontalListItem