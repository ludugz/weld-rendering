package styler.weld.rendering.models.local.itemlist

import styler.weld.rendering.models.remote.BaseItem

data class ItemListItem(
    override val brand: String,
    override val discount: Any?,
    override val id: String,
    override val image: String,
    override val name: String,
    override val price_with_tax: Double?,
    override val shop_id: String,
    override val type: String
) : BaseItem()