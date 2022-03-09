package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import styler.weld.rendering.R

class WidgetFactory {

    var factories: MutableList<FactoryMethod> = mutableListOf();

    fun register(type: String) {
        factories.add(FactoryMethod(type))
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

class FactoryMethod(val type: String) {
    fun createViewHolder(parent: ViewGroup): BaseViewHolder {
        return when (type) {
            "banner" -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.banner_row_item, parent, false)
                BannerViewHolder(view)
            }
            "item_list" -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list_row_item, parent, false)
                ItemListViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.empty_view_row_item, parent, false)
                EmptyViewHolder(view)
            }
        }
    }
}

