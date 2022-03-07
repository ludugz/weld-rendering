# weld-rendering
An example of how to render Widget Definition List with generic response in Android

![Mar-07-2022 18-21-47](https://user-images.githubusercontent.com/31622343/157003358-9205a326-a06a-4558-963d-a607eab0506d.gif)

Since we need to handle generic types of a Json response, a parent data class that contains every fields is defined as below:

```
open class BaseItem(
    open val brand: String? = null,
    open val discount: Any? = null,
    open val id: String? = null,
    open val image: String? = null,
    open val name: String? = null,
    open val price_with_tax: Double? = null,
    open val shop_id: String? = null,
    open val type: String? = null,
    open val logo: String? = null,
    open val image_url: String? = null,
    open val url: String? = null,
    open val title: String? = null,
    open val excerpt: String? = null
)
```

And in the adapter of each type, the transformed version of `BaseItem` is handled, for example `item_list` type in `HorizontalAdapter`, as below:
```
        val itemList: List<ItemListItem>? = baseList?.map {
            ItemListItem(
                it.brand,
                it.discount,
                it.id,
                it.image,
                it.name,
                it.price_with_tax,
                it.shop_id,
                it.type
            )
        }
```
You can have a further look into the response at `weld-rendering/app/src/main/assets/response.json`


