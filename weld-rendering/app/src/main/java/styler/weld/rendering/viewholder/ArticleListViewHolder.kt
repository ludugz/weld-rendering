package styler.weld.rendering.viewholder

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.adapter.ArticleAdapter
import styler.weld.rendering.models.remote.WidgetData

class ArticleListViewHolder(
    itemView: View
) : BaseViewHolder(itemView) {
    private val tvLabel: TextView = itemView.findViewById(R.id.text_view_label_article)
    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_article)

    override fun bindData(WidgetData data) {
        val data = GSON.parse(widgetData.data, ArticleData.type)
        recyclerView.apply {
            adapter = ArticleAdapter(data, "article")
            layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
        }
        tvLabel.text = widgetData.title
    }
}

fun BaseViewHolder createViewHolder(parent) {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_row_item, parent, false)
    return ArticleListViewHolder(view)
}

class ArticleData {
    var title: String;
    ...
}