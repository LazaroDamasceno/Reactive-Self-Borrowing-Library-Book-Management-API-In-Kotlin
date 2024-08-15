package com.api.v1.book.services

import reactor.core.publisher.Mono

interface DeleteBookByIsbnService {

    fun deleteByIsbn(isbn: String): Mono<Void>

}