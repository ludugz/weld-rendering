package styler.weld.rendering.models.remote

import styler.weld.rendering.models.local.Data

open class WidgetData (
    open val type: String,
    open val title: String,
    val data: Data
)