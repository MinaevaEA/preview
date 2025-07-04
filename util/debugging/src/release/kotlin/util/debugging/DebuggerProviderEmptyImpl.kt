package util.debugging

import okhttp3.Interceptor

internal class DebuggerProviderEmptyImpl : DebuggerProvider {

    override fun getDebugNetworkInterceptors(): List<Interceptor> = emptyList()

}
