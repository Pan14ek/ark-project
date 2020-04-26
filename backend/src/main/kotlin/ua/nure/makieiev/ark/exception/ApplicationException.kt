package ua.nure.makieiev.ark.exception

open class ApplicationException(message: String?,
                                cause: Throwable?,
                                enableSuppression: Boolean,
                                writableStackTrace: Boolean) : RuntimeException(message, cause, enableSuppression, writableStackTrace) {
}