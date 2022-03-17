package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.ArticleAdapter
import styler.weld.rendering.models.local.articlelist.ArticleListItem
import styler.weld.rendering.models.remote.WidgetData

class ArticleListViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val tvLabel: TextView = itemView.findViewById(R.id.text_view_label_article)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_article)

    override fun bindData(data: WidgetData) {
        recyclerView.apply {
            adapter = ArticleAdapter(articleListFromBaseData(data), "article")
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
        }
        tvLabel.text = data.title
    }

    private fun articleListFromBaseData(data: WidgetData): List<ArticleListItem>? {
        return (data.data["items"] as List<*>?)?.map {
            it as Map<*, *>
            ArticleListItem(
                it["image_url"] as String,
                it["url"] as String,
                it["title"] as String,
                it["excerpt"] as String,
            )
        }
    }

    companion object {
        fun create(parent: ViewGroup): BaseViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_list_row_item, parent, false)
            return ArticleListViewHolder(view)
        }
    }
}