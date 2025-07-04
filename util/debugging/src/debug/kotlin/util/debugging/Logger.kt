package util.debugging

import timber.log.Timber

object Logger : BaseLogger {

    override fun debug(tag: String, message: String) {
        Timber.tag(tag).d(message)
    }

    override fun error(tag: String, ex: Throwable) {
        Timber.tag(tag).e(ex)
    }

    override fun error(ex: Throwable) {
        Timber.e(ex)
    }

    override fun warning(ex: Throwable) {
        Timber.w(ex)
    }

}
