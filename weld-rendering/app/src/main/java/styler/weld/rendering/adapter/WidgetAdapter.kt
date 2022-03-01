package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.Widget
import styler.weld.rendering.viewholder.BannerViewHolder
import styler.weld.rendering.viewholder.BaseViewHolder

class WidgetAdapter(private val response: Widget?) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        // TODO: Banner type for now
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_row_item, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
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