package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import styler.weld.rendering.R
import styler.weld.rendering.models.remote.WidgetData

class EmptyViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    override fun bindData(data: WidgetData) {}

    companion object {
        fun create(parent: ViewGroup): BaseViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.empty_view_row_item, parent, false)
            return EmptyViewHolder(view)
        }
    }
}