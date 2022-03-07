package styler.weld.rendering.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.*

class WidgetAdapter(private val response: Widget<BaseData>?) :
    RecyclerView.Adapter<BaseViewHolder<WidgetData<BaseData>>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<WidgetData<BaseData>> {
        return when (viewType) {
            BANNER_TYPE -> {
                bannerViewHolder(parent)
            }
            ITEM_LIST_TYPE -> {
                itemListViewHolder(parent)
            }
            LOCAL_RECENT_ITEMS -> {
                itemListViewHolder(parent)
            }
            SHOP_LIST -> {
                shopListViewHolder(parent)
            }
            else -> emptyViewHolder(parent)
        }
    }

    private fun itemListViewHolder(parent: ViewGroup): ItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_row_item, parent, false)
        return ItemListViewHolder(view, response?.widgets)
    }

    private fun shopListViewHolder(parent: ViewGroup): ShopListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.shop_list_row_item, parent, false)
        return ShopListViewHolder(view, response?.widgets)
    }

    private fun bannerViewHolder(parent: ViewGroup): BannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banner_row_item, parent, false)
        return BannerViewHolder(view, response?.widgets)
    }

    private fun emptyViewHolder(parent: ViewGroup): EmptyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.empty_view_row_item, parent, false)
        return EmptyViewHolder(view, response?.widgets)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<WidgetData<BaseData>>, position: Int) {
        holder.bindData()
    }

    override fun getItemCount(): Int {
        return response?.widgets?.size ?: 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (response?.widgets?.get(position)?.type) {
            "banner" -> BANNER_TYPE
            "item_list" -> ITEM_LIST_TYPE
            "local_recent_items" -> LOCAL_RECENT_ITEMS
            "shop_list" -> SHOP_LIST
            else -> INVALID_TYPE
        }
    }

    companion object {
        private const val INVALID_TYPE = 0
        private const val BANNER_TYPE = 1
        private const val ITEM_LIST_TYPE = 2
        private const val LOCAL_RECENT_ITEMS = 3
        private const val SHOP_LIST = 4
    }
}