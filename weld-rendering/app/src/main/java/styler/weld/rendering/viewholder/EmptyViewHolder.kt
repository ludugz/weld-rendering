package styler.weld.rendering.viewholder

import android.view.View
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.WidgetData

class EmptyViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    override fun bindData() {}
}