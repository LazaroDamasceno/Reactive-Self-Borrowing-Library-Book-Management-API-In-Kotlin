package com.api.v1.book.services

import com.api.v1.book.builders.BookBuilder
import com.api.v1.book.domain.Book
import com.api.v1.book.domain.BookRepository
import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.dtos.NewBookRequestDto
import com.api.v1.book.mappers.BookResponseMapper
import com.api.v1.borrower.exceptions.DuplicatedSsnException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class RegisterBookServiceImpl: RegisterBookService {

    @Autowired
    private lateinit var repository: BookRepository

    override fun register(@Valid request: NewBookRequestDto): Mono<BookResponseDto> {
        return repository.getByIsbn(request.isbn).hasElement().flatMap {
            exists ->
                if (exists) duplicatedSsnError()
                else defer(request)
        }
    }

    private fun duplicatedSsnError(): Mono<BookResponseDto> {
        val message = "ISBN is already used."
        return Mono.error(DuplicatedSsnException(message));
    }

    private fun defer(request: NewBookRequestDto): Mono<BookResponseDto> {
        return Mono.defer {
            val book: Book = BookBuilder.fromDto(request).build()
            val savedBook: Mono<Book> = repository.save(book)
            savedBook.flatMap { b -> Mono.just(BookResponseMapper.map(b)) }
        }
    }

}