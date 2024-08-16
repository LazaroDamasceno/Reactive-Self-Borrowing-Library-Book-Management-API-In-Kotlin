package com.api.v1.borrow.services

import com.api.v1.annotations.ISBN
import reactor.core.publisher.Mono

interface DeleteBorrowService {

    fun delete(isbn: String, ssn: String): Mono<Void>

}