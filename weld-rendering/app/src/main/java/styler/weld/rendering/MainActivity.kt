package styler.weld.rendering

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import styler.weld.rendering.adapter.WidgetAdapter
import styler.weld.rendering.factory.WidgetFactory
import styler.weld.rendering.models.remote.WidgetData
import styler.weld.rendering.models.remote.WidgetDefinitionList
import styler.weld.rendering.utils.GsonUtils
import styler.weld.rendering.viewholder.*
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    private var widgetDataList = listOf<WidgetData>()

    private val widgetFactory = WidgetFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initViews()
    }

    private fun initViews() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        widgetFactory.register("banner") { parent ->
            BannerViewHolder.create(parent)
        }

        widgetFactory.register("item_list") { parent ->
            ItemListViewHolder.create(parent)
        }

        widgetFactory.register("shop_list") { parent ->
            ShopListViewHolder.create(parent)
        }

        widgetFactory.register("article_list") { parent ->
            ArticleListViewHolder.create(parent)
        }

        widgetFactory.register("invalid") { parent ->
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.empty_view_row_item, parent, false)
            return@register EmptyViewHolder(view)
        }

        recycler_view.apply {
            adapter = WidgetAdapter(widgetDataList, widgetFactory)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun initData() {
        val type: Type = object : TypeToken<WidgetDefinitionList>() {}.type
        val widgetDefinitionList: WidgetDefinitionList =
            GsonUtils.instance!!.fromJson(responseFromFile(), type)
        widgetDataList = widgetDefinitionList.widgets
    }

    private fun responseFromFile() =
        applicationContext.assets.open("response.json").bufferedReader().use { it.readText() }
}