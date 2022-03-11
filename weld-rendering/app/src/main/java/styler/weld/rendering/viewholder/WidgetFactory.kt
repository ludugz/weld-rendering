package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import styler.weld.rendering.R

class WidgetFactory {

    private var factories: MutableList<FactoryMethod> = mutableListOf()

    fun register(type: String, factory: (parent: ViewGroup) -> BaseViewHolder) {
        factories.add(FactoryMethod(type, factory))
    }

    fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder {
        if (viewType == INVALID) {
            // TODO: INVALID case should be refactored later
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.empty_view_row_item, parent, false)
            return EmptyViewHolder(view)
        }
        return factories[viewType].createViewHolder(parent)
    }

    fun getViewTypeFor(type: String): Int {
        val factory = factories.findLast { it.type == type }
        return if (factory == null) {
            INVALID
        } else {
            factories.indexOf(factory)
        }
    }

    companion object {
        const val INVALID = -1
    }
}

class FactoryMethod(val type: String, val factory: (parent: ViewGroup) -> BaseViewHolder) {
    fun createViewHolder(parent: ViewGroup): BaseViewHolder = factory(parent)
}

