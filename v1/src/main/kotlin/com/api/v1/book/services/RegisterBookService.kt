package com.api.v1.book.services

import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.dtos.NewBookRequestDto
import reactor.core.publisher.Mono

interface RegisterBookService {

    fun register(request: NewBookRequestDto): Mono<BookResponseDto>

}