package styler.weld.rendering.utils

import styler.weld.rendering.models.local.banner.BannerData
import styler.weld.rendering.models.local.itemlist.ItemListData
import styler.weld.rendering.models.local.itemlist.ItemListItem
import styler.weld.rendering.models.remote.Widget
import styler.weld.rendering.models.remote.WidgetData


fun imageFromId(imageId: String): String {
    return "https://api.stg.facy.jp/images/$imageId/original.jpeg"
}

fun fakeData(): Widget {
    return Widget(
        listOf(
            WidgetData(
                "banner",
                "クーポンキャンペーン",
                BannerData(
                    "767f9b6a-7f99-4a20-9fba-205f6122f679",
                    "page=webview&url=https%3A%2F%2Ffacy.jp%2Fenjoy-facy-coupon%2F&title=クーポンキャンペーン"
                ),
            ),
            WidgetData(
                "item_list",
                "今気になる春アウターは？",
                ItemListData(
                    listOf(
                        ItemListItem(
                            "EDIFICE",
                            null,
                            "a0135c37-dfce-498b-9824-d2eaf94e71a1",
                            "2f6434a6-b090-4808-a19a-801fb5bd36d1",
                            "L2-B リバーシブル フライトブルゾン",
                            23100.0,
                            "fb82f6e4-df9a-4f51-b80c-0d9d68967e30",
                            "item"
                        ),
                        ItemListItem(
                            "EDIFICE",
                            null,
                            "69588f36-bce7-4813-8d01-3384d734c2f3",
                            "59da5187-bf7c-415e-8ce4-5822e4d1517a",
                            "【Barbour / バブアー】OVERSIZE WAX BEAUFORT (ビューフォート)",
                            23100.0,
                            "fb82f6e4-df9a-4f51-b80c-0d9d68967e30",
                            "item"
                        ),
                        ItemListItem(
                            "JOURNAL STANDARD",
                            null,
                            "d6d4cb91-ac21-4456-9ac6-3cb8220176e4",
                            "df59875e-ee99-43ce-82ad-9e6bc13d4f19",
                            "【CIOTA / シオタ】スビンコットンタイロッケンコート",
                            null,
                            "4e507a25-fed3-4778-9a2e-470836ee26c7",
                            "item"
                        ),
                    )
                ),
            )
        )
    )
}

fun formattedPrice(price: Double?) : String {
    return "¥$price (税込)"
}
