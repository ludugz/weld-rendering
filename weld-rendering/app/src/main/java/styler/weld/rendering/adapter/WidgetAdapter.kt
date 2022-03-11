package styler.weld.rendering.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.BaseViewHolder
import styler.weld.rendering.factory.WidgetFactory

class WidgetAdapter(
    private val widgets: List<WidgetData>,
    private val widgetFactory: WidgetFactory
) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var viewHolder: BaseViewHolder? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        viewHolder = widgetFactory.createViewHolder(viewType, parent)
        return viewHolder as BaseViewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        viewHolder?.bindData(widgets[position])
    }

    override fun getItemCount(): Int {
        return widgets.count()
    }

    override fun getItemViewType(position: Int): Int {
        return widgetFactory.getViewTypeFor(widgets[position].type);
    }
}