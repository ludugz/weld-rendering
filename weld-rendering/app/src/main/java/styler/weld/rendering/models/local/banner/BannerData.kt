package styler.weld.rendering.models.local.banner

import styler.weld.rendering.models.local.BaseData

data class BannerData(
    val image_id: String,
    val target: String
) : BaseData()