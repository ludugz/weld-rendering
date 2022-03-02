package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.local.banner.Banner
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.viewholder.BannerViewHolder
import styler.weld.rendering.viewholder.BaseViewHolder

class WidgetAdapter(private val response: Widget?) : RecyclerView.Adapter<BaseViewHolder<WidgetData>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<WidgetData> {
        // TODO: Banner type for now
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_row_item, parent, false)
        return BannerViewHolder(view, response?.widgets)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<WidgetData>, position: Int) {
        holder.bindData()
    }

    override fun getItemCount() = response?.widgets?.size ?: 1

    override fun getItemViewType(position: Int): Int {
        // TODO: Return BANNER_TYPE for now
        return BANNER_TYPE
    }

    companion object {
        private const val BANNER_TYPE = 1
        private const val ITEM_LIST_TYPE = 2
    }
}