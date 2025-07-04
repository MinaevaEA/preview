package util.debugging

import okhttp3.Interceptor

interface DebuggerProvider {

    fun getDebugNetworkInterceptors(): List<Interceptor>

}
