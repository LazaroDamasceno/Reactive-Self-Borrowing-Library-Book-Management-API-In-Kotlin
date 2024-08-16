package com.api.v1.borrow.utils

import com.api.v1.book.domain.Book
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.domain.BorrowRepository
import com.api.v1.borrow.exceptions.BorrowNotFoundException
import com.api.v1.borrower.domain.Borrower
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class BorrowFinderUtil {

    @Autowired
    private lateinit var repository: BorrowRepository

    fun findActive(book: Book, borrower: Borrower): Mono<Borrow> {
        return repository
            .findActiveBorrow(borrower, book)
            .switchIfEmpty(Mono.error(BorrowNotFoundException()))
    }

    fun findAny(book: Book, borrower: Borrower): Mono<Borrow> {
        return repository
            .findAnyBorrow(borrower, book)
            .switchIfEmpty(Mono.error(BorrowNotFoundException()))
    }

}