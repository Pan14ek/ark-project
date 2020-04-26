package ua.nure.makieiev.ark.exception.response

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class ConflictException(message: String?) : RuntimeException(message)