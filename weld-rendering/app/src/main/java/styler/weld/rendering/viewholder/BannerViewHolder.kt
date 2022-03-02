package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.banner.BannerData
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.utils.imageFromId

class BannerViewHolder(
    itemView: View,
    private val bannerList: List<WidgetData>?
) : BaseViewHolder<WidgetData>(itemView, bannerList) {
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_banner)
    override fun bindData() {
        val data = bannerList?.get(0)!!.data
        if (data is BannerData) {
            Glide.with(itemView.context).load(imageFromId(data.image_id)).into(imageView)
        }
    }
}