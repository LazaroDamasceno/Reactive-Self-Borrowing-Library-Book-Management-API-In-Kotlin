package com.api.v1.borrower.services

import com.api.v1.borrower.dtos.BorrowerResponseDto
import reactor.core.publisher.Flux

interface FindAllBorrowersService {

    fun findAll(): Flux<BorrowerResponseDto>

}