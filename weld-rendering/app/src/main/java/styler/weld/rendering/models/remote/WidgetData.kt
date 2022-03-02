package styler.weld.rendering.models.remote

import styler.weld.rendering.models.local.BaseData

open class WidgetData(
    val data: BaseData,
    open val title: String,
    open val type: String
)