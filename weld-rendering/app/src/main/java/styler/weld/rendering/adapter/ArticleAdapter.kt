package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.articlelist.ArticleListItem
import styler.weld.rendering.viewholder.*

class ArticleAdapter(
    private val articleList: List<ArticleListItem>?,
    private val type: String
) : RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return when (viewType) {
            ARTICLE_TYPE -> articleViewHolder(parent)
            else -> emptyViewHolder(parent)
        }
    }

    private fun articleViewHolder(parent: ViewGroup): HorizontalViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_article_list_row_item, parent, false)
        return VerticalArticleViewHolder(view, articleList)
    }

    private fun emptyViewHolder(parent: ViewGroup): HorizontalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.empty_view_row_item, parent, false)
        return EmptyHorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bindData()
    }

    override fun getItemCount(): Int {
        return articleList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (type) {
            "article" -> ARTICLE_TYPE
            else -> INVALID_TYPE
        }
    }

    companion object {
        private const val INVALID_TYPE = 0
        private const val ARTICLE_TYPE = 2
    }
}