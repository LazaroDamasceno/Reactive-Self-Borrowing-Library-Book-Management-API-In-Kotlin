package com.api.v1.book.services

import reactor.core.publisher.Mono

interface DeleteAllBooksService {

    fun deleteAll(): Mono<Void>

}