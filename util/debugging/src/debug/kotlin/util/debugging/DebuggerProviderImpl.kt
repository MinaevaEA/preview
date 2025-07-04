package util.debugging

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class DebuggerProviderImpl(
    private val networkFlipperPlugin: NetworkFlipperPlugin,
) : DebuggerProvider {

    override fun getDebugNetworkInterceptors(): List<Interceptor> = listOf(
        FlipperOkhttpInterceptor(networkFlipperPlugin, MOCKS_ENABLED),
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )

    companion object {
        private const val MOCKS_ENABLED = true
    }

}
