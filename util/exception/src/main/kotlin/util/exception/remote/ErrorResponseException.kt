package util.exception.remote

import util.exception.model.RemoteExceptionData

class ErrorResponseException(
    val code: Int,
    val data: RemoteExceptionData?,
) : RemoteException(data?.message)
