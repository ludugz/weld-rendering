package styler.weld.rendering.models.remote

open class WidgetData (
    open val type: String,
    open val title: String,
    val data: Map<String, Any>
)