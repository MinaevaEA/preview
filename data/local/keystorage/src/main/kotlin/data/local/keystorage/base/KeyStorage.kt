package data.local.keystorage.base

import com.badoo.reaktive.completable.Completable
import com.badoo.reaktive.completable.andThen
import com.badoo.reaktive.completable.completable
import com.badoo.reaktive.completable.subscribeOn
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.single.Single
import com.badoo.reaktive.single.single
import com.badoo.reaktive.single.subscribeOn
import com.tencent.mmkv.MMKV
import data.local.keystorage.exception.NoSuchElementInKeyStorageException

/**
 * Реактивная обертка над MMKV
 */
internal abstract class KeyStorage(
    private val mmkv: MMKV
) {

    fun saveString(key: String, value: String): Completable = completable { emitter ->
        try {
            mmkv.encode(key, value)
            emitter.onComplete()
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

    fun saveStringWithExpiration(
        key: String,
        value: String,
        expirationTime: Int
    ): Completable = saveString(key, value)
        .andThen(saveInt("${key}_expiration", expirationTime))

    fun getString(key: String): Single<String> = single { emitter ->
        try {
            var value = mmkv.decodeString(key)

            val expirationTime = mmkv.decodeInt("${key}_expiration", -1)
            if (expirationTime > -1) {
                val accuracy = expirationTime.toString().length
                val currentTime = System.currentTimeMillis().toString().take(accuracy).toInt()

                if (currentTime >= expirationTime) {
                    mmkv.remove(key)
                    mmkv.remove("${key}_expiration")
                    value = null
                }
            }

            if (value == null) {
                emitter.onError(NoSuchElementInKeyStorageException(key))
            } else {
                emitter.onSuccess(value)
            }
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

    fun getStringSynchronously(key: String): String? {
        return mmkv.decodeString(key)
    }

    fun saveBoolean(key: String, value: Boolean): Completable =
        completable { emitter ->
        try {
            mmkv.encode(key, value)
            emitter.onComplete()
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

    fun getBoolean(key: String, defaultValue: Boolean): Single<Boolean> = single { emitter ->
        try {
            val value = mmkv.decodeBool(key, defaultValue)
            emitter.onSuccess(value)
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }

    fun saveInt(key: String, value: Int): Completable = completable { emitter ->
        try {
            mmkv.encode(key, value)
            emitter.onComplete()
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

    fun getInt(key: String): Single<Int> = single { emitter ->
        val value = mmkv.decodeInt(key, -1)
        if (value == -1) {
            emitter.onError(NoSuchElementInKeyStorageException(key))
        } else {
            emitter.onSuccess(value)
        }
    }

    fun saveLong(key: String, value: Long): Completable = completable { emitter ->
        try {
            mmkv.encode(key, value)
            emitter.onComplete()
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

    fun getLong(key: String): Single<Long> = single { emitter ->
        val value = mmkv.decodeLong(key, -1L)
        if (value == -1L) {
            emitter.onError(NoSuchElementInKeyStorageException(key))
        } else {
            emitter.onSuccess(value)
        }
    }

    fun remove(key: String): Completable = completable { emitter ->
        try {
            mmkv.removeValueForKey(key)
            emitter.onComplete()
        } catch (ex: Throwable) {
            emitter.onError(ex)
        }
    }
        .subscribeOn(ioScheduler)

}

