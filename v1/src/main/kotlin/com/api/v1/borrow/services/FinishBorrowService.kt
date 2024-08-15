package com.api.v1.borrow.services

import com.api.v1.borrow.domain.Borrow
import reactor.core.publisher.Mono

interface FinishBorrowService {

    fun finish(isbn: String, ssn: String): Mono<Borrow>

}