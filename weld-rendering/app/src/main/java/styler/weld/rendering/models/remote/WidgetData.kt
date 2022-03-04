package styler.weld.rendering.models.remote

import styler.weld.rendering.models.local.BaseData

open class WidgetData <T : BaseData>(
    open val type: String,
    open val title: String,
    val data: T
)