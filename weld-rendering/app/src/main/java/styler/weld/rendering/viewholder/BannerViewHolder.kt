package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.utils.imageFromId

class BannerViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_banner)

    override fun bindData(data: WidgetData) {
        val imageIdStr = data.data["image_id"] as String? ?: "" // TODO: Should be refactored to support nullable type 
        Glide.with(itemView.context).load(imageFromId(imageIdStr)).into(imageView)
    }
}