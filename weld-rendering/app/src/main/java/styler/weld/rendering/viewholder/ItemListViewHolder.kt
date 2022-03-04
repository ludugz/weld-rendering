package styler.weld.rendering.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.HorizontalAdapter
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.WidgetData

class ItemListViewHolder(
    itemView: View,
    private val widgetData: List<WidgetData<BaseData>>?
) : BaseViewHolder<WidgetData<BaseData>>(itemView, widgetData) {
    private val title: TextView = itemView.findViewById(R.id.text_view_title_item_list)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_item_list)
    override fun bindData() {
        val data = widgetData?.get(1)!!.data
        if (data is ItemListData) {
            recyclerView.apply {
                adapter = HorizontalAdapter(data.items)
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            }
            title.text = widgetData[1].title
        }
    }
}