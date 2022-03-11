package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.HorizontalAdapter
import styler.weld.rendering.models.local.HorizontalListItem
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.remote.WidgetData

class ItemListViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.text_view_title_item)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_item)
    override fun bindData(data: WidgetData) {
        recyclerView.apply {
            adapter = HorizontalAdapter(itemListFromBaseData(data), "item")
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            title.text = data.title
        }
    }

    private fun itemListFromBaseData(data: WidgetData) : List<HorizontalListItem>? {
        return (data.data["items"] as List<*>?)?.map {
            it as Map<*, *>
            ItemListItem(
                it["brand"] as String,
                it["discount"],
                it["id"] as String,
                it["image"] as String,
                it["name"] as String,
                it["price_with_tax"] as Double?,
                it["shop_id"] as String,
                it["type"] as String
            )
        }
    }

    companion object {
        fun create(parent: ViewGroup): BaseViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_row_item, parent, false)
            return ItemListViewHolder(view)
        }
    }
}