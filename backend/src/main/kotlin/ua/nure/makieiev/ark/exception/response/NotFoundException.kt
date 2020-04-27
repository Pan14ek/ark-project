package ua.nure.makieiev.ark.exception.response

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(NOT_FOUND)
class NotFoundException(message: String?) : RuntimeException(message)