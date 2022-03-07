package styler.weld.rendering.models.local.shoplist

import styler.weld.rendering.models.local.HorizontalItem

data class ShopListItem(
    val id: String?,
    val name: String?,
    val logo: String?
) : HorizontalItem