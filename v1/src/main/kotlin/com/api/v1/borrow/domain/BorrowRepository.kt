package com.api.v1.borrow.domain

import com.api.v1.book.domain.Book
import com.api.v1.borrower.domain.Borrower
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface BorrowRepository: ReactiveCrudRepository<Borrow, UUID> {

    @Query("""{ 
        'borrower': borrower, 
        'book': book,
        'returnedDate': null
    }""")
    fun get(borrower: Borrower, book: Book): Mono<Borrow>

}