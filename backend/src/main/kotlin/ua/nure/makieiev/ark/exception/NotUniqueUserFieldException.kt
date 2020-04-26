package ua.nure.makieiev.ark.exception

open class NotUniqueUserFieldException(message: String?,
                                       cause: Throwable?,
                                       enableSuppression: Boolean,
                                       writableStackTrace: Boolean) : ApplicationException(message, cause, enableSuppression, writableStackTrace) {
}