package util.debugging

object Logger : BaseLogger {

    override fun error(tag: String, ex: Throwable) {
        // Nothing to do
    }

    override fun error(ex: Throwable) {
        // Nothing to do
    }

    override fun debug(tag: String, message: String) {
        // Nothing to do
    }

    override fun warning(ex: Throwable) {
        // Nothing to do
    }

}
