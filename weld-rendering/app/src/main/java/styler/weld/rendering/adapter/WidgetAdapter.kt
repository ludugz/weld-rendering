package styler.weld.rendering.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.*

class WidgetAdapter(private val widgets: List<WidgetData>, private val widgetFactory: WidgetFactory) :
    RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        return widgetFactory.createViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return widgets.count()
    }

    override fun getItemViewType(position: Int): Int {
        return widgetFactory.getViewTypeFor(widgets[position].type);
    }
}