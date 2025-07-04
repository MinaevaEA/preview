package data.local.keystorage.di

import android.content.Context
import data.local.keystorage.BuildConfig
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MMKVModule {

    private const val KEY_STORAGE_FILE_NAME = "boostmmkv"

    @Provides
    @Singleton
    fun provideMMKV(
        @ApplicationContext context: Context,
    ): MMKV {
        MMKV.initialize(context)

        return MMKV.mmkvWithID(
            KEY_STORAGE_FILE_NAME,
            MMKV.SINGLE_PROCESS_MODE,
            BuildConfig.MMKV_KEY
        )
    }

}
