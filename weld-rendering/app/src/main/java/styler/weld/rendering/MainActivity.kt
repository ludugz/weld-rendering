package styler.weld.rendering

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import styler.weld.rendering.adapter.WidgetAdapter
import styler.weld.rendering.models.local.articlelist.ArticleListItem
import styler.weld.rendering.models.remote.WidgetDefinitionList
import styler.weld.rendering.utils.GsonUtils
import styler.weld.rendering.viewholder.ArticleListViewHolder
import styler.weld.rendering.viewholder.ItemListViewHolder
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    private var widgetData: Widget? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        initData()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        var widgetFactory = new WidgetFactory();
        widgetFactory.register("area_selection", ....factory)
        widgetFactory.register("feed", ....feedfactory)
        widgetFactory.register("article_list", ArticleListViewHolder.factory)
        widgetFactory.register("item_list", ItemListViewHolder.factory)

        widgetData.add(0, new WidgetData(type: "area_selection"))
        widgetData.add(widgetData.length - 1, new WidgetData(type: "feed"))

        recycler_view.apply {
            adapter = WidgetAdapter(widgetData)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun initData() {
        val type: Type = object : TypeToken<WidgetDefinitionList>() {}.type
        widgetData = GsonUtils.instance!!.fromJson(responseFromFile(), type)
    }

    private fun responseFromFile() =
        applicationContext.assets.open("response.json").bufferedReader().use { it.readText() }
}