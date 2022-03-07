package styler.weld.rendering.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import styler.weld.rendering.R
import styler.weld.rendering.models.local.articlelist.ArticleListItem
import styler.weld.rendering.models.local.shoplist.ShopListItem
import styler.weld.rendering.utils.imageFromId

class VerticalArticleViewHolder(
    itemView: View,
    private val listData: List<ArticleListItem>?
) : HorizontalViewHolder(itemView) {
    private val imgLogo: ImageView = itemView.findViewById(R.id.image_view_logo_article)
    private val tvTitle: TextView = itemView.findViewById(R.id.text_view_title_article)
    private val tvDescription: TextView = itemView.findViewById(R.id.text_view_description_article)
    override fun bindData() {
        val data = listData?.get(adapterPosition)
        Glide.with(itemView.context).load(data?.image_url).into(imgLogo)
        tvTitle.text = data?.title
        tvDescription.text = data?.excerpt
    }
}