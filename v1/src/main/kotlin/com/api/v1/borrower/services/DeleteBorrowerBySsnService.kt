package com.api.v1.borrower.services

import reactor.core.publisher.Mono

interface DeleteBorrowerBySsnService {

    fun deleteBySsn(ssn: String): Mono<Void>

}