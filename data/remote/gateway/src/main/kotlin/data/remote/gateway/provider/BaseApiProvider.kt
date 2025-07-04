package data.remote.gateway.provider

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

abstract class BaseApiProvider<Api>(
    private val connectTimeout: Long,
    private val readTimeout: Long,
    private val contentType: MediaType,
    private val defaultUrl: String,
    private val interceptors: List<Interceptor>
) {

    val api: Api
        get() = _api ?: createApi(provideRetrofit(defaultUrl)).also { _api = it }

    private var _api: Api = createApi(provideRetrofit(defaultUrl))

    lateinit var serializer: Json

    abstract fun createApi(retrofit: Retrofit): Api

    protected open fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        with(builder) {
            connectTimeout(connectTimeout, TimeUnit.SECONDS)
            readTimeout(readTimeout, TimeUnit.SECONDS)
            interceptors.forEach { interceptor ->
                addInterceptor(interceptor)
            }
        }

        return builder.build()
    }

    protected open fun provideRetrofit(url: String): Retrofit {
        serializer = Json {
            encodeDefaults = true
            explicitNulls = false
            ignoreUnknownKeys = true
        }

        val converterFactory = serializer.asConverterFactory(contentType)

        val httpClient = provideHttpClient()

        val builder = Retrofit.Builder()

        with(builder) {
            addConverterFactory(converterFactory)
            client(httpClient)
            baseUrl(url)
        }

        return builder.build()
    }

}
