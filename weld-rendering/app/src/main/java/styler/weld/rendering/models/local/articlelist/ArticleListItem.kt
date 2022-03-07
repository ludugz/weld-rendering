package styler.weld.rendering.models.local.articlelist

import styler.weld.rendering.models.remote.BaseItem

data class ArticleListItem(
    override val image_url: String? = null,
    override val url: String? = null,
    override val title: String? = null,
    override val excerpt: String? = null
) : BaseItem()