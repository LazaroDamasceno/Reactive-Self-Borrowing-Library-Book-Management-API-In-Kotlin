package com.api.v1.book.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface BookRepository: ReactiveCrudRepository<Book, UUID> {

}