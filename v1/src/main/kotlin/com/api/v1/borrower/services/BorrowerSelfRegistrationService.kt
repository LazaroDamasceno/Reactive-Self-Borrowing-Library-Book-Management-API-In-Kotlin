package com.api.v1.borrower.services

import com.api.v1.borrower.dtos.BorrowerResponseDto
import com.api.v1.borrower.dtos.NewBorrowerRequestDto
import reactor.core.publisher.Mono

interface BorrowerSelfRegistrationService {

    fun selfRegister(request: NewBorrowerRequestDto): Mono<BorrowerResponseDto>

}