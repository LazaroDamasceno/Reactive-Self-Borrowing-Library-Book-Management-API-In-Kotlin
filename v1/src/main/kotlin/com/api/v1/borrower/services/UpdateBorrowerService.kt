package com.api.v1.borrower.services

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.dtos.UpdateBorrowerRequestDto
import reactor.core.publisher.Mono

interface UpdateBorrowerService {

    fun update(ssn: String, request: UpdateBorrowerRequestDto): Mono<Borrower>;

}