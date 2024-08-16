package com.api.v1.borrow.services

import reactor.core.publisher.Mono

interface DeleteAllBorrowsService {

    fun deleteAll(): Mono<Void>

}