package util.exception.local

class CacheException : LocalException {

    constructor(mes: String? = null) : super(mes)

    constructor(ex: Throwable) : super(ex)

}
