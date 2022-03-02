package styler.weld.rendering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import styler.weld.rendering.R
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.viewholder.HorizontalViewHolder

class HorizontalAdapter(private val itemList: List<ItemListItem>?) :
    RecyclerView.Adapter<HorizontalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_list_row_item, parent, false)
        return HorizontalViewHolder(itemView, itemList)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bindData()
    }

    override fun getItemCount() = itemList?.size ?: 0

}