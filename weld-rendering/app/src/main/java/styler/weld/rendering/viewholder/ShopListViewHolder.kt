package styler.weld.rendering.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.HorizontalAdapter
import styler.weld.rendering.models.local.HorizontalListItem
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.local.shoplist.ShopListItem
import styler.weld.rendering.models.remote.WidgetData

class ShopListViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.text_view_shop_name)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_shop)
    override fun bindData(data: WidgetData) {
        recyclerView.apply {
            adapter = HorizontalAdapter(shopListFromBaseData(data), "shop")
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            title.text = data.title
        }
    }

    private fun shopListFromBaseData(data: WidgetData) : List<HorizontalListItem>? {
        return (data.data["items"] as List<*>?)?.map {
            it as Map<*, *>
            ShopListItem(
                it["id"] as String,
                it["name"] as String,
                it["logo"] as String
            )
        }
    }
}