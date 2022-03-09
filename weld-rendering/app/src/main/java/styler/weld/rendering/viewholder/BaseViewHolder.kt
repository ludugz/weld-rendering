package styler.weld.rendering.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.models.remote.WidgetData

abstract class BaseViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(data: WidgetData)
}