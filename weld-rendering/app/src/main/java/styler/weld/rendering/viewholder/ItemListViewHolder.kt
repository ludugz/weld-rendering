package styler.weld.rendering.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.HorizontalAdapter
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.remote.WidgetData

class ItemListViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.text_view_title_item)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_item)
    override fun bindData(data: WidgetData) {
        recyclerView.apply {
            // TODO: Left for future reference, but can probably be deleted
//            val itemList = data.data["items"] as List<BaseItem>
//            val itemList = (data.data["items"] as List<*>).filterIsInstance<ItemListItem>().takeIf {
//                it.size == (data.data["items"] as List<*>).size
//            }
            
            // TODO: Might need to refactor this part
            val itemList = (data.data["items"] as List<*>?)?.map {
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

            adapter = HorizontalAdapter(itemList, "item")
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            title.text = data.title
        }
    }
}