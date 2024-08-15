package com.api.v1.book.domain

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface BookRepository: ReactiveCrudRepository<Book, UUID> {

    @Query("{ 'isbn': ?0 }")
    fun getByIsbn(isbn: String): Mono<Book>

}