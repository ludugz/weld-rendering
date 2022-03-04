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
import styler.weld.rendering.viewholder.ItemListViewHolder

class WidgetAdapter(private val response: Widget<BaseData>?) :
    RecyclerView.Adapter<BaseViewHolder<WidgetData<BaseData>>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<WidgetData<BaseData>> {
        return when (viewType) {
            BANNER_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.banner_row_item, parent, false)
                BannerViewHolder(view, response?.widgets)
            }
            ITEM_LIST_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_list_row_item, parent, false)
                ItemListViewHolder(view, response?.widgets)
            }
            else -> TODO("Invalid type")
        }
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