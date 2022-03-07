package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.utils.formattedPrice
import styler.weld.rendering.utils.imageFromId

class HorizontalItemViewHolder(
    itemView: View,
    private val listData: List<ItemListItem>?
) : HorizontalViewHolder(itemView) {
    private val tvBrand: TextView = itemView.findViewById(R.id.text_view_item_brand)
    private val tvPrice: TextView = itemView.findViewById(R.id.text_view_item_price)
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_item_icon)
    override fun bindData() {
        val data = listData?.get(adapterPosition)
        tvBrand.text = data?.brand
        tvPrice.text = formattedPrice(data?.price_with_tax)
        Glide.with(itemView.context).load(data?.image?.let { imageFromId(it) }).into(imageView)
    }
}