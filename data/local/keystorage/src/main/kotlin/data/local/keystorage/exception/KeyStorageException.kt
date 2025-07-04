package data.local.keystorage.exception

import util.exception.local.LocalStorageException

abstract class KeyStorageException(original: Throwable) : LocalStorageException(original)

