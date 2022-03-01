package styler.weld.rendering.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WidgetAdapter : RecyclerView.Adapter<BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        // TODO: Return BANNER_TYPE for now
        return BANNER_TYPE
    }

}