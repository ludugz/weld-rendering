package styler.weld.rendering.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type

object GsonUtils {
    private var instance: Gson? = null
        get() {
            if (field == null) {
                val gsonBuilder = GsonBuilder()
                field = gsonBuilder.create()
            }
            return field
        }

    fun object2String(obj: Any?): String {
        return instance!!.toJson(obj)
    }

    fun <T> string2Object(json: String?, clzz: Class<T>?): T? {
        return try {
            instance!!.fromJson(json, clzz)
        } catch (ex: JsonSyntaxException) {
            ex.printStackTrace()
            null
        }
    }

    fun <T> string2ListObject(json: String?, type: Type?): T {
        return instance!!.fromJson(json, type)
    }
}