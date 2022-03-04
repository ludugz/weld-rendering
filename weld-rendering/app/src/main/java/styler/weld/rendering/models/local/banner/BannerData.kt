package styler.weld.rendering.models.local.banner

import styler.weld.rendering.models.local.BaseData

data class BannerData(
    override val image_id: String,
    override val target: String
) : BaseData()