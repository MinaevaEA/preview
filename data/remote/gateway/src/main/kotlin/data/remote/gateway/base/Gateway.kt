package data.remote.gateway.base

import com.badoo.reaktive.completable.Completable
import com.badoo.reaktive.coroutinesinterop.completableFromCoroutine
import com.badoo.reaktive.coroutinesinterop.singleFromCoroutine
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.single.Single
import com.badoo.reaktive.single.subscribeOn
import kotlinx.coroutines.CoroutineScope

internal abstract class Gateway(
) {

    protected fun <D : Any> makeRequestSingle(
        request: suspend CoroutineScope.() -> D
    ): Single<D> = singleFromCoroutine(request)
        .subscribeOn(ioScheduler)

    protected fun makeRequestCompletable(
        request: suspend CoroutineScope.() -> Unit
    ): Completable = completableFromCoroutine(request)

}
