package com.api.v1.book.services

import com.api.v1.book.dtos.BookResponseDto
import reactor.core.publisher.Flux

interface FindAllBooksService {

    fun findAll(): Flux<BookResponseDto>
    fun findByAuthor(author: String): Flux<BookResponseDto>
    fun findByField(field: String): Flux<BookResponseDto>
    fun findByYear(year: Int): Flux<BookResponseDto>
    fun findByFieldAndYear(field: String, year: Int): Flux<BookResponseDto>
    fun findByAuthorAndField(author: String, field: String): Flux<BookResponseDto>
    fun find(author: String, field: String, year: Int): Flux<BookResponseDto>

}