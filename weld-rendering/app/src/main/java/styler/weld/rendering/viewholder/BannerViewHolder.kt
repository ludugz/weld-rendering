package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.utils.imageFromId

class BannerViewHolder(
    itemView: View,
    private val widgetData: List<WidgetData<BaseData>>?
) : BaseViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_banner)
    override fun bindData() {
        widgetData?.forEach { widgetData ->
            if (widgetData.type == "banner") {
                val data = widgetData.data
                Glide.with(itemView.context).load(imageFromId(data.image_id!!)).into(imageView)
            }
        }
    }
}