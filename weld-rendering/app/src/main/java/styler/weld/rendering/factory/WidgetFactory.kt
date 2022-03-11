package styler.weld.rendering.factory

import android.view.ViewGroup
import styler.weld.rendering.viewholder.BaseViewHolder

class WidgetFactory {

    private var factories: MutableList<FactoryMethod> = mutableListOf()

    fun register(type: String, factory: (parent: ViewGroup) -> BaseViewHolder) {
        factories.add(FactoryMethod(type, factory))
    }

    fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder {
        return factories[viewType].createViewHolder(parent)
    }

    fun getViewTypeFor(type: String): Int {
        val factory = factories.findLast { it.type == type }
        return if (factory == null) {
            factories.lastIndex
        } else {
            factories.indexOf(factory)
        }
    }
}

class FactoryMethod(val type: String, val factory: (parent: ViewGroup) -> BaseViewHolder) {
    fun createViewHolder(parent: ViewGroup): BaseViewHolder = factory(parent)
}

