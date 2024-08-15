package com.api.v1.borrow.services

import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.dtos.NewBorrowRequestDto
import reactor.core.publisher.Mono

interface BorrowBookService {

    fun borrow(request: NewBorrowRequestDto): Mono<BorrowResponseDto>

}