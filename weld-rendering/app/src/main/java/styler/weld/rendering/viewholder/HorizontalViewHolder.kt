package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.utils.imageFromId

class HorizontalViewHolder(
    itemView: View,
    private val listData: List<ItemListItem>?
) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.text_view_brand_horizontal)
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_horizontal)
    fun bindData() {
        val data = listData?.get(adapterPosition)
        textView.text = data?.brand
        Glide.with(itemView.context).load(data?.image?.let { imageFromId(it) }).into(imageView)
    }
}