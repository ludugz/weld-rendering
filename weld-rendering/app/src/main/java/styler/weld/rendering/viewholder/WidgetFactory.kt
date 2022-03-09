package styler.weld.rendering.viewholder

import android.view.ViewGroup

class WidgetFactory {

    var factories: MutableList<FactoryMethod> = mutableListOf();

    fun register(type: String, factory: (parent: ViewGroup) -> BaseViewHolder) {
        factories.add(FactoryMethod(type, factory));
    }

    fun createViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return factories[viewType].createViewHolder(parent)
    }

    fun getViewTypeFor(type: String): Int {
        // should default to a -1 or something to signify an unsupported type
        var factory = factories.findLast { it.type == type }
        if (factory == null) return fallback
        return factories.indexOf(factory)
    }

    companion object {
        const fallback: int = -1;
    }
}

class FactoryMethod(type: String, factory: (parent: ViewGroup) -> BaseViewHolder) {

}