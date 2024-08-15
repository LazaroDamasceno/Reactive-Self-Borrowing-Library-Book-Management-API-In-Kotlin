package com.api.v1.borrow.services

import com.api.v1.book.domain.Book
import com.api.v1.book.utils.BookFinderUtil
import com.api.v1.borrow.builders.BorrowBuilder
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.domain.BorrowRepository
import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.dtos.NewBorrowRequestDto
import com.api.v1.borrow.exceptions.BorrowLimitReachedException
import com.api.v1.borrow.mappers.BorrowResponseMapper
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.utils.BorrowerFinderUtil
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class BorrowBookServiceImpl: BorrowBookService {

    @Autowired
    private lateinit var repository: BorrowRepository

    @Autowired
    private lateinit var bookFinder: BookFinderUtil

    @Autowired
    private lateinit var borrowerFinder: BorrowerFinderUtil

    override fun borrow(@Valid request: NewBorrowRequestDto): Mono<BorrowResponseDto> {
        val bookMono: Mono<Book> = bookFinder.find(request.isbn)
        val borrowerMono: Mono<Borrower> = borrowerFinder.find(request.ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMap { tuple ->
                val book: Book = tuple.t1
                val borrower: Borrower = tuple.t2
                response(book, borrower)
            }
    }

    private val borrowLimit: Long = 3L

    private fun response(book: Book, borrower: Borrower): Mono<BorrowResponseDto> {
        return repository
            .countHowManyActiveBorrowsByBorrowers(borrower)
            .flatMap { count ->
                if (count.equals(borrowLimit)) {
                    handleBorrowLimitReached()
                }
                else handleBorrow(book, borrower)
            }
    }

    private fun handleBorrowLimitReached():  Mono<BorrowResponseDto> {
        return Mono.error(BorrowLimitReachedException())
    }

    private fun handleBorrow(book: Book, borrower: Borrower):  Mono<BorrowResponseDto> {
        val borrow: Borrow = BorrowBuilder
            .create()
            .withBorrower(borrower)
            .withBook(book)
            .build()
        val savedBorrow: Mono<Borrow> = repository.save(borrow)
        return savedBorrow.flatMap{ b -> Mono.just(BorrowResponseMapper.map(b)) }
    }

}