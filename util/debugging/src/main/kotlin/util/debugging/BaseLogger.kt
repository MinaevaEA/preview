package util.debugging

interface BaseLogger {

    fun error(tag: String, ex: Throwable)

    fun error(ex: Throwable)

    fun debug(tag: String, message: String)

    fun warning(ex: Throwable)

}
