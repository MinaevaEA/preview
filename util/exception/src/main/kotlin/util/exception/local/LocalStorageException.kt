package util.exception.local

/**
 * Ошибка внутренненго хранилища данных
 */
abstract class LocalStorageException(original: Throwable) : LocalException(original)
