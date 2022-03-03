package styler.weld.rendering.models.remote

import styler.weld.rendering.models.local.BaseData

open class WidgetData(
    open val type: String,
    open val title: String,
    val data: BaseData
)