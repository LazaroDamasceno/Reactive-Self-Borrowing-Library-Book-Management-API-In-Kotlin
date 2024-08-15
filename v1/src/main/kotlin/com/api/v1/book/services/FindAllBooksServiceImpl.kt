package com.api.v1.book.services

import com.api.v1.book.domain.Book
import com.api.v1.book.domain.BookRepository
import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.mappers.BookResponseMapper
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
internal class FindAllBooksServiceImpl: FindAllBooksService {

    @Autowired
    private lateinit var repository: BookRepository

    override fun findAll(): Flux<BookResponseDto> {
        return repository
            .findAll()
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun findByAuthor(@NotBlank author: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.author == author }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun findByField(@NotBlank field: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun findByYear(year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.publishingYear == year }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun findByFieldAndYear(@NotBlank field: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.publishingYear == year }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun findByAuthorAndField(@NotBlank author: String, @NotBlank field: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.author == author }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }

    override fun find(@NotBlank author: String, @NotBlank field: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.author == author && e.publishingYear == year }
            .flatMap { e -> Flux.just(BookResponseMapper.map(e)) }
    }


}