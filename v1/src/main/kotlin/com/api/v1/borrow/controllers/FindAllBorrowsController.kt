package com.api.v1.borrow.controllers

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.services.FindAllBorrowsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/v1/borrows")
internal class FindAllBorrowsController {

    @Autowired
    private lateinit var service: FindAllBorrowsService

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAll(): Flux<BorrowResponseDto> {
        return service.findAll()
    }

    @GetMapping("all/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByIsbn(@PathVariable @ISBN isbn: String): Flux<BorrowResponseDto> {
        return service.findAllByIsbn(isbn)
    }

    @GetMapping("all/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllByIsbnAndYear(@PathVariable @ISBN isbn: String, @PathVariable year: Int): Flux<BorrowResponseDto> {
        return service.findAllByIsbnAndYear(isbn, year)
    }

    @GetMapping("all/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllBySsn(@PathVariable @SSN ssn: String): Flux<BorrowResponseDto> {
        return service.findAllBySsn(ssn)
    }


    @GetMapping("all/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllBySsnAndYear(@PathVariable @SSN ssn: String, @PathVariable year: Int): Flux<BorrowResponseDto> {
        return service.findAllBySsnAndYear(ssn, year)
    }

    @GetMapping("all/by-borrower/{ssn}/and/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllByIsbnAndSsnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllByIsbnAndSsnAndYear(isbn, ssn, year)
    }

    @GetMapping("all/by-borrower/{ssn}/and/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllByIsbnAndSsn(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String
    ): Flux<BorrowResponseDto> {
        return service.findAllByIsbnAndSsn(isbn, ssn)
    }

    @GetMapping("active")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActive(): Flux<BorrowResponseDto> {
        return service.findAllActive()
    }

    @GetMapping("active/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveByIsbn(@PathVariable @ISBN isbn: String): Flux<BorrowResponseDto> {
        return service.findAllActiveByIsbn(isbn)
    }

    @GetMapping("active/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveByIsbnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllActiveByIsbnAndYear(isbn, year)
    }

    @GetMapping("active/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveBySsn(@PathVariable @SSN ssn: String): Flux<BorrowResponseDto> {
        return service.findAllActiveBySsn(ssn)
    }

    @GetMapping("active/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveBySsnAndYear(@PathVariable @SSN ssn: String, @PathVariable year: Int): Flux<BorrowResponseDto> {
        return service.findAllActiveBySsnAndYear(ssn, year)
    }

    @GetMapping("active/by-book/{isbn}/and/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveByIsbnAndSsnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllActiveByIsbnAndSsnAndYear(isbn, ssn, year)
    }

    @GetMapping("active/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllActiveByIsbnAndSsn(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String
    ): Flux<BorrowResponseDto> {
        return service.findAllActiveByIsbnAndSsn(isbn, ssn)
    }

    @GetMapping("overdue")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdue(): Flux<BorrowResponseDto> {
        return service.findAllOverdue()
    }

    @GetMapping("overdue/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueByIsbn(@PathVariable @ISBN isbn: String): Flux<BorrowResponseDto> {
        return service.findAllOverdueByIsbn(isbn)
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueByIsbnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllOverdueByIsbnAndYear(isbn, year)
    }

    @GetMapping("overdue/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueBySsn(@PathVariable @SSN ssn: String): Flux<BorrowResponseDto> {
        return service.findAllOverdueBySsn(ssn)
    }

    @GetMapping("overdue/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueBySsnAndYear(@PathVariable @SSN ssn: String, @PathVariable year: Int): Flux<BorrowResponseDto> {
        return service.findAllOverdueBySsnAndYear(ssn, year)
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueByIsbnAndSsnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllOverdueByIsbnAndSsnAndYear(isbn, ssn, year)
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllOverdueByIsbnAndSsn(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String
    ): Flux<BorrowResponseDto> {
        return service.findAllOverdueByIsbnAndSsn(isbn, ssn)
    }

    @GetMapping("finished")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinished(): Flux<BorrowResponseDto> {
        return service.findAllFinished()
    }

    @GetMapping("finished/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedByIsbn(@PathVariable @ISBN isbn: String): Flux<BorrowResponseDto> {
        return service.findAllFinishedByIsbn(isbn)
    }

    @GetMapping("finished/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedByIsbnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllFinishedByIsbnAndYear(isbn, year)
    }

    @GetMapping("finished/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedBySsn(@PathVariable @SSN ssn: String): Flux<BorrowResponseDto> {
        return service.findAllFinishedBySsn(ssn)
    }

    @GetMapping("finished/by-borrower/{ssn}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedBySsnAndYear(
        @PathVariable @SSN ssn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllFinishedBySsnAndYear(ssn, year)
    }

    @GetMapping("finished/by-book/{isbn}/and/by-borrower/{ssn}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedByIsbnAndSsnAndYear(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String,
        @PathVariable year: Int
    ): Flux<BorrowResponseDto> {
        return service.findAllFinishedByIsbnAndSsnAndYear(isbn, ssn, year)
    }

    @GetMapping("finished/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findAllFinishedByIsbnAndSsn(
        @PathVariable @ISBN isbn: String,
        @PathVariable @SSN ssn: String
    ): Flux<BorrowResponseDto> {
        return service.findAllFinishedByIsbnAndSsn(isbn, ssn)
    }
    
}