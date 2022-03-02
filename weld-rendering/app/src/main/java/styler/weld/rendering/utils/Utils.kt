package styler.weld.rendering.utils

import styler.weld.rendering.models.local.banner.BannerData
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData


fun imageFromId(imageId: String): String {
    return "https://api.stg.facy.jp/images/$imageId/original.jpeg"
}

fun fakeData(): Widget {
    return Widget(
        listOf(WidgetData(
            BannerData("767f9b6a-7f99-4a20-9fba-205f6122f679", "page=webview&url=https%3A%2F%2Ffacy.jp%2Fenjoy-facy-coupon%2F&title=クーポンキャンペーン"),
            "クーポンキャンペーン",
            "banner"
        ))
    )
}