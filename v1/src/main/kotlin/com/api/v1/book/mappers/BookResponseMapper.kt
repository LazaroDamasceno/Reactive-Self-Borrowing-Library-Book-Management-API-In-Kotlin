package com.api.v1.book.mappers

import com.api.v1.book.domain.Book
import com.api.v1.book.dtos.BookResponseDto

class BookResponseMapper {

    companion object {
        fun map(book: Book): BookResponseDto {
            return BookResponseDto(
                book.getFullTitle(),
                book.isbn,
                book.publisher,
                book.publishingYear,
                book.version,
                book.numberOfPages,
                book.author,
                book.field,
                book.addedAt,
                book.updatedAt
            )
        }
    }

}