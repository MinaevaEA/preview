package data.local.db.base

import com.badoo.reaktive.completable.Completable
import com.badoo.reaktive.completable.subscribeOn
import com.badoo.reaktive.coroutinesinterop.completableFromCoroutine
import com.badoo.reaktive.coroutinesinterop.singleFromCoroutine
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.single.Single
import com.badoo.reaktive.single.subscribeOn
import kotlinx.coroutines.CoroutineScope

abstract class Database() {

    protected fun <D : Any?> executeQuerySingle(
        query: suspend CoroutineScope.() -> D
    ): Single<D> = singleFromCoroutine(query)
        .subscribeOn(ioScheduler)

    protected fun executeQueryCompletable(
        query: suspend CoroutineScope.() -> Unit
    ): Completable = completableFromCoroutine(query)
        .subscribeOn(ioScheduler)

}
