package util.debugging

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import util.debugging.plugins.MMKVFlipperPlugin
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DebuggerModule {

    @Provides
    @Singleton
    fun provideDebugger(
        @ApplicationContext context: Context,
        mmkv: MMKV
    ): DebuggerProvider {
        initTimber()

        SoLoader.init(context, false)

        val networkFlipperPlugin = NetworkFlipperPlugin()

        val client = AndroidFlipperClient.getInstance(context).apply {
            addPlugin(networkFlipperPlugin)
            addPlugin(MMKVFlipperPlugin(mmkv))
        }

        client.start()

        return DebuggerProviderImpl(networkFlipperPlugin)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

}
