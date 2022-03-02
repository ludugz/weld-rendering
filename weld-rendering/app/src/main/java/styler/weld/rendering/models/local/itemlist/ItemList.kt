package styler.weld.rendering.models.local.itemlist

import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.WidgetData

data class ItemList(
    val itemListData: ItemListData,
    override val title: String,
    override val type: String
) : WidgetData(itemListData, title, type)