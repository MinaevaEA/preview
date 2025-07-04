package data.local.keystorage.exception

import data.local.keystorage.exception.KeyStorageException

class NoSuchElementInKeyStorageException(key: String) : KeyStorageException(
    NoSuchElementException("There is no element with key $key in the key storage")
)

