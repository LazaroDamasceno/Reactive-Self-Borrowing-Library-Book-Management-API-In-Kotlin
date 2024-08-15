package com.api.v1.borrow.services

import com.api.v1.borrow.dtos.BorrowResponseDto
import reactor.core.publisher.Flux

interface FindAllBorrowsService {

    fun findAll(): Flux<BorrowResponseDto>
    fun findAllByIsbn(isbn: String): Flux<BorrowResponseDto>
    fun findAllByIsbnAndYear(isbn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllBySsn(ssn: String): Flux<BorrowResponseDto>
    fun findAllBySsnAndYear(ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllByIsbnAndSsnAndYear(isbn: String, ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllByIsbnAndSsn(isbn: String, ssn: String): Flux<BorrowResponseDto>
    fun findAllActive(): Flux<BorrowResponseDto>
    fun findAllActiveByIsbn(isbn: String): Flux<BorrowResponseDto>
    fun findAllActiveByIsbnAndYear(isbn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllActiveBySsn(ssn: String): Flux<BorrowResponseDto>
    fun findAllActiveBySsnAndYear(ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllActiveByIsbnAndSsnAndYear(isbn: String, ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllActiveByIsbnAndSsn(isbn: String, ssn: String): Flux<BorrowResponseDto>
    fun findAllOverdue(): Flux<BorrowResponseDto>
    fun findAllOverdueByIsbn(isbn: String): Flux<BorrowResponseDto>
    fun findAllOverdueByIsbnAndYear(isbn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllOverdueBySsn(ssn: String): Flux<BorrowResponseDto>
    fun findAllOverdueBySsnAndYear(ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllOverdueByIsbnAndSsnAndYear(isbn: String, ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllOverdueByIsbnAndSsn(isbn: String, ssn: String): Flux<BorrowResponseDto>
    fun findAllFinished(): Flux<BorrowResponseDto>
    fun findAllFinishedByIsbn(isbn: String): Flux<BorrowResponseDto>
    fun findAllFinishedByIsbnAndYear(isbn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllFinishedBySsn(ssn: String): Flux<BorrowResponseDto>
    fun findAllFinishedBySsnAndYear(ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllFinishedByIsbnAndSsnAndYear(isbn: String, ssn: String, year: Int): Flux<BorrowResponseDto>
    fun findAllFinishedByIsbnAndSsn(isbn: String, ssn: String): Flux<BorrowResponseDto>
    
}