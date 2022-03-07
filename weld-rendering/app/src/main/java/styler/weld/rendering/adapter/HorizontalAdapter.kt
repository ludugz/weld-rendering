package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.remote.BaseItem
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.local.shoplist.ShopListItem
import styler.weld.rendering.viewholder.EmptyHorizontalViewHolder
import styler.weld.rendering.viewholder.HorizontalItemViewHolder
import styler.weld.rendering.viewholder.HorizontalShopViewHolder
import styler.weld.rendering.viewholder.HorizontalViewHolder

class HorizontalAdapter(
    private val baseList: List<BaseItem>?,
    private val type: String
) :
    RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return when (viewType) {
            ITEM_TYPE -> itemViewHolder(parent)
            SHOP_TYPE -> shopViewHolder(parent)
            else -> emptyViewHolder(parent)
        }
    }

    private fun itemViewHolder(parent: ViewGroup): HorizontalItemViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.horizontal_item_list_row_item, parent, false)
        val itemList: List<ItemListItem>? = baseList?.map {
            ItemListItem(
                it.brand,
                it.discount,
                it.id,
                it.image,
                it.name,
                it.price_with_tax,
                it.shop_id,
                it.type
            )
        }
        return HorizontalItemViewHolder(view, itemList)
    }

    private fun shopViewHolder(parent: ViewGroup): HorizontalShopViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.horizontal_shop_list_row_item, parent, false)
        val shopList: List<ShopListItem>? = baseList?.map {
            ShopListItem(
                it.id,
                it.name,
                it.logo
            )
        }
        return HorizontalShopViewHolder(view, shopList)
    }

    private fun emptyViewHolder(parent: ViewGroup): EmptyHorizontalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.empty_view_row_item, parent, false)
        return EmptyHorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bindData()
    }

    override fun getItemCount() : Int {
        return baseList?.size ?: 0
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