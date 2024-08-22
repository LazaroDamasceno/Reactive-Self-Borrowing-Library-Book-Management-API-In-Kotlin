package com.api.v1.borrower.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface BorrowerRepository: ReactiveCrudRepository<Borrower, UUID> {

}