package util.exception.remote

import java.io.IOException

abstract class RemoteException(message: String? = null) : IOException(message)
