package styler.weld.rendering.models.remote

import styler.weld.rendering.models.local.BaseData

data class Widget<T : BaseData>(
    val widgets: List<WidgetData<T>>
)