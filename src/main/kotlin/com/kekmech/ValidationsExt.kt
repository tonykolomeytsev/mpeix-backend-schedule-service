package com.kekmech

import io.ktor.client.statement.*
import io.ktor.http.*

fun String?.checkIsValidGroupNumber(): String {
    if (!(this != null && matches("[а-яА-Я0-9-]{5,20}".toRegex())))
        throw InvalidArgumentException("Text $this is not a group number")
    return this.toUpperCase().replace("-0", "-")
}

fun HttpResponse.checkGroupFound(): HttpResponse {
    if (status != HttpStatusCode.Found)
        throw MpeiBackendUnexpectedBehaviorException("GROUP_NOT_FOUND")
    return this
}

fun HttpResponse.checkCode(statusCode: HttpStatusCode): HttpResponse {
    if (status != statusCode)
        throw MpeiBackendUnexpectedBehaviorException()
    return this
}

fun<T : Any> T.assertUnexpectedBehavior(predicate: (T) -> Boolean): T {
    if (!predicate(this))
        throw MpeiBackendUnexpectedBehaviorException("ERROR_PARSE_GROUP_ID")
    return this
}