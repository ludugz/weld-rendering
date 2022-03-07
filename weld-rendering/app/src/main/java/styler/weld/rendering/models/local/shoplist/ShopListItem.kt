package styler.weld.rendering.models.local.shoplist

import styler.weld.rendering.models.local.BaseItem

data class ShopListItem(
    override val id: String,
    override val name: String,
    override val logo: String
) : BaseItem()