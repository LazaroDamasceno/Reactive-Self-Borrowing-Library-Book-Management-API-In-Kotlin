package com.api.v1.borrow.services

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.book.domain.Book
import com.api.v1.book.utils.BookFinderUtil
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.domain.BorrowRepository
import com.api.v1.borrow.utils.BorrowFinderUtil
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.utils.BorrowerFinderUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class FinishBorrowServiceImpl: FinishBorrowService {

    @Autowired
    private lateinit var repository: BorrowRepository

    @Autowired
    private lateinit var bookFinder: BookFinderUtil

    @Autowired
    private lateinit var borrowerFinder: BorrowerFinderUtil

    @Autowired
    private lateinit var borrowFinder: BorrowFinderUtil

    override fun finish(@ISBN isbn: String, @SSN ssn: String): Mono<Borrow> {
        val bookMono: Mono<Book> = bookFinder.find(isbn)
        val borrowerMono: Mono<Borrower> = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMap { tuple ->
                val book: Book = tuple.t1
                val borrower: Borrower = tuple.t2
                borrowFinder.find(book, borrower)
            }
            .flatMap { borrow ->
                borrow.finishBorrow()
                repository.save(borrow)
            }
    }

}