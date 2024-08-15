package com.api.v1.book.builders

import com.api.v1.book.domain.Book
import com.api.v1.book.dtos.NewBookRequestDto
import jakarta.validation.Valid
import java.time.ZonedDateTime
import java.util.*

class BookBuilder {

    private val id: UUID = UUID.randomUUID()
    private var title: String
    private var subtitle: String
    private var isbn: String
    private var publishingYear: Int
    private var publisher: String
    private var version: Int = 0
    private var numberOfPages: Int = 0
    private var author: String
    private var field: String
    private val addedAt: String = ZonedDateTime.now().toString()

    private constructor(request: NewBookRequestDto) {
        this.title = request.title
        this.subtitle = request.subtitle
        this.isbn = request.isbn
        this.publishingYear = request.publishingYear
        this.publisher = request.publisher
        this.version = request.version
        this.numberOfPages = request.numberOfPages
        this.author = request.author
        this.field = request.field
    }

    companion object {
        fun fromDto(@Valid request: NewBookRequestDto): BookBuilder {
            return BookBuilder(request)
        }
    }

    fun build(): Book {
        return Book(
            id,
            title,
            subtitle,
            isbn,
            publisher,
            publishingYear,
            version,
            numberOfPages,
            author,
            field,
            addedAt
        )
    }

}