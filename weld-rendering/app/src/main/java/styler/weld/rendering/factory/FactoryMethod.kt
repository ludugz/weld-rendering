package styler.weld.rendering.factory

import android.view.ViewGroup
import styler.weld.rendering.viewholder.BaseViewHolder

class FactoryMethod(val type: String, val factory: (parent: ViewGroup) -> BaseViewHolder) {
    fun createViewHolder(parent: ViewGroup): BaseViewHolder = factory(parent)
}