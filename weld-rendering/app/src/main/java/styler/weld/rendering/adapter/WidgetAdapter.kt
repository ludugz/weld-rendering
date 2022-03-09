package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.*

class WidgetAdapter(private val response: List<WidgetData>, private val widgetFactory: WidgetFactory) :
    RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        return widgetFactory.createViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return response?.widgets?.size ?: 1
    }

    override fun getItemViewType(position: Int): Int {
        return widgetFactory.getViewTypeFor(widgets[position].type);
    }
}