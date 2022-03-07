package styler.weld.rendering.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.HorizontalAdapter
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.WidgetData

class ShopListViewHolder(
    itemView: View,
    private val widgetDataList: List<WidgetData<BaseData>>?
) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.text_view_shop_name)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_shop)
    override fun bindData() {
        widgetDataList?.forEach { widgetData ->
            if (widgetData.type == "shop_list") {
                val data = widgetData.data
                recyclerView.apply {
                    adapter = HorizontalAdapter(data.items, "shop")
                    layoutManager =
                        LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    title.text = widgetData.title
                }
            }
        }
    }
}