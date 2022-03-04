package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.BannerViewHolder
import styler.weld.rendering.viewholder.BaseViewHolder
import styler.weld.rendering.viewholder.EmptyViewHolder
import styler.weld.rendering.viewholder.ItemListViewHolder

class WidgetAdapter(private val response: Widget<BaseData>?) :
    RecyclerView.Adapter<BaseViewHolder<WidgetData<BaseData>>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<WidgetData<BaseData>> {
        return when (viewType) {
            BANNER_TYPE -> bannerViewHolder(parent)
            ITEM_LIST_TYPE -> itemListViewHolder(parent)
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.empty_view_row_item, parent, false)
                EmptyViewHolder(view, null)
            }
        }
    }

    private fun itemListViewHolder(parent: ViewGroup): ItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_row_item, parent, false)
        return ItemListViewHolder(view, response?.widgets)
    }

    private fun bannerViewHolder(parent: ViewGroup): BannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banner_row_item, parent, false)
        return BannerViewHolder(view, response?.widgets)
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
            else -> INVALID_TYPE
        }
    }

    companion object {
        private const val INVALID_TYPE = 0
        private const val BANNER_TYPE = 1
        private const val ITEM_LIST_TYPE = 2
    }
}