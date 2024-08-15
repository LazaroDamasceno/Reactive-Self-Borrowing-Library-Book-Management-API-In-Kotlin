package com.api.v1.borrower.services

import reactor.core.publisher.Mono

interface DeleteAllBorrowersService {

    fun deleteAll(): Mono<Void>

}