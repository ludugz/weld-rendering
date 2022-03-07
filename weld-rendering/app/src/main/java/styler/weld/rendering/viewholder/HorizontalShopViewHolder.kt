package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.shoplist.ShopListItem
import styler.weld.rendering.utils.imageFromId

class HorizontalShopViewHolder(
    itemView: View,
    private val listData: List<ShopListItem>?
) : HorizontalViewHolder(itemView) {
    private val tvBrand: TextView = itemView.findViewById(R.id.text_view_shop_name)
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_shop_logo)
    override fun bindData() {
        val data = listData?.get(adapterPosition)
        tvBrand.text = data?.name
        Glide.with(itemView.context).load(data?.logo?.let { imageFromId(it) }).into(imageView)
    }
}