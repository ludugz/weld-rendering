package styler.weld.rendering

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import styler.weld.rendering.adapter.WidgetAdapter
import styler.weld.rendering.models.local.BaseData
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.utils.GsonUtils
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    private var widgetData: Widget<BaseData>? = null

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
        recycler_view.apply {
            adapter = WidgetAdapter(fakeData())
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun initData() {
        val type: Type = object : TypeToken<Widget<BaseData>>() {}.type
        widgetData = GsonUtils.instance!!.fromJson(responseFromFile(), type)
    }

    private fun responseFromFile() =
        applicationContext.assets.open("response.json").bufferedReader().use { it.readText() }
}