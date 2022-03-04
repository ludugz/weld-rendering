package styler.weld.rendering.models.local.itemlist

import styler.weld.rendering.models.local.BaseData

data class ItemListData(
    override val items: List<ItemListItem>
) : BaseData()