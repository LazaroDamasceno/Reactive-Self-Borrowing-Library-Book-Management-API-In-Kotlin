package com.api.v1.borrower.domain

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface BorrowerRepository: ReactiveCrudRepository<Borrower, UUID> {

    @Query("{ 'ssn': ?0 }")
    fun getBySsn(ssn: String): Mono<Borrower>

}