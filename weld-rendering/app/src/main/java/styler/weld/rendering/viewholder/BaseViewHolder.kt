package styler.weld.rendering.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<K>(
    itemView: View,
    val listData: List<K>
) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData()
}