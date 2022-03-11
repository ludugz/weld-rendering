package styler.weld.rendering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import styler.weld.rendering.adapter.WidgetAdapter
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
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.banner_row_item, parent, false)
            return@register BannerViewHolder(view)
        }

        widgetFactory.register("item_list") { parent ->
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_row_item, parent, false)
            return@register ItemListViewHolder(view)
        }

        widgetFactory.register("shop_list") { parent ->
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.shop_list_row_item, parent, false)
            return@register ShopListViewHolder(view)
        }

        // examples in case you would handle area and feed in the same
//        widgetFactory.register("area_selection", ....factory)
//        widgetFactory.register("feed", ....feedfactory)
//        widgetData.add(0, new WidgetData(type: "area_selection"))
//        widgetData.add(widgetData.length - 1, new WidgetData(type: "feed"))
        widgetFactory.register("article_list") { parent ->
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_list_row_item, parent, false)
            return@register ArticleListViewHolder(view)
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