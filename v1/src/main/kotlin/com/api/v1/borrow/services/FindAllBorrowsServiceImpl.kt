package com.api.v1.borrow.services

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.book.domain.Book
import com.api.v1.book.utils.BookFinderUtil
import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.mappers.BorrowResponseMapper
import com.api.v1.borrow.utils.FindBorrowsUtil
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.utils.BorrowerFinderUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZonedDateTime

@Service
internal class FindAllBorrowsServiceImpl: FindAllBorrowsService {

    @Autowired
    private lateinit var findBorrows: FindBorrowsUtil

    @Autowired
    private lateinit var bookFinder: BookFinderUtil

    @Autowired
    private lateinit var borrowerFinder: BorrowerFinderUtil

    override fun findAll(): Flux<BorrowResponseDto> {
        return findBorrows
            .findAll()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { book: Book ->
                findBorrows
                    .findAll()
                    .filter { e -> e.book == book }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { book: Book ->
                findBorrows
                    .findAll()
                    .filter { e -> e.book == book 
                            && ZonedDateTime.parse(e.borrowedDate).year == year 
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { borrower: Borrower ->
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { borrower: Borrower ->
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower
                                && e.book == book
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllActive(): Flux<BorrowResponseDto> {
        return findBorrows
            .findActive()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllActiveByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findActive()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllActiveByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findActive()
                    .filter { e -> e.book == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllActiveBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllActiveBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllActiveByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == borrower
                                && e.book == book
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllActiveByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllOverdue(): Flux<BorrowResponseDto> {
        return findBorrows
            .findOverdue()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllOverdueByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllOverdueByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.book == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllOverdueBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllOverdueBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllOverdueByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == borrower && e.book == book
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllOverdueByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllFinished(): Flux<BorrowResponseDto> {
        return findBorrows
            .findFinished()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllFinishedByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllFinishedByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany { b: Book ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllFinishedBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllFinishedBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany { b: Borrower ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.borrower == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    override fun findAllFinishedByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findFinished()
                    .filter { e ->
                                e.book == book && e.borrower == borrower
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    override fun findAllFinishedByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip(bookMono, borrowerMono)
            .flatMapMany { tuple ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == book && e.borrower == borrower }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }
    
}