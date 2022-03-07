package styler.weld.rendering.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class HorizontalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData()
}