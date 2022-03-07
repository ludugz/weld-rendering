package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.HorizontalItem
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.local.shoplist.ShopListItem
import styler.weld.rendering.viewholder.HorizontalItemViewHolder
import styler.weld.rendering.viewholder.HorizontalShopViewHolder
import styler.weld.rendering.viewholder.HorizontalViewHolder

class HorizontalAdapter(private val list: List<HorizontalItem>?) :
    RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        // Item List
        if (viewType == ITEM_TYPE) {
            return itemViewHolder(parent)
        }
        return shopViewHolder(parent)
    }

    private fun itemViewHolder(parent: ViewGroup): HorizontalItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item_list_row_item, parent, false)
        val itemList: List<ItemListItem> = list!!.filterIsInstance<ItemListItem>()
        return HorizontalItemViewHolder(view, itemList)
    }

    private fun shopViewHolder(parent: ViewGroup): HorizontalShopViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_shop_list_row_item, parent, false)
        val shopList: List<ShopListItem> = list!!.filterIsInstance<ShopListItem>()
        return HorizontalShopViewHolder(view, shopList)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bindData()
    }

    override fun getItemCount() : Int {
        return list?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (type) {
            "item" -> ITEM_TYPE
            "shop" -> SHOP_TYPE
            else -> INVALID_TYPE
        }
    }

    companion object {
        private const val INVALID_TYPE = 0
        private const val ITEM_TYPE = 1
        private const val SHOP_TYPE = 2
    }
}