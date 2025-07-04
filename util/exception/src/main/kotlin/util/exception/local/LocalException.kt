package util.exception.local

import java.io.IOException

abstract class LocalException : IOException {

    constructor(mes: String?) : super(mes)

    constructor(ex: Throwable) : super(ex)

}
