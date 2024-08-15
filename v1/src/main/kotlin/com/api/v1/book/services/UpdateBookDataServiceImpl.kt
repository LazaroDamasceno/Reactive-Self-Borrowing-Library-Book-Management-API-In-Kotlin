package com.api.v1.book.services

import com.api.v1.annotations.ISBN
import com.api.v1.book.domain.Book
import com.api.v1.book.domain.BookRepository
import com.api.v1.book.dtos.UpdateBookRequestDto
import com.api.v1.book.utils.BookFinderUtil
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class UpdateBookDataServiceImpl: UpdateBookDataService {

    @Autowired
    private lateinit var repository: BookRepository

    @Autowired
    private lateinit var finder: BookFinderUtil

    override fun update(
        @ISBN isbn: String,
        @Valid request: UpdateBookRequestDto
    ): Mono<Book> {
        return finder.find(isbn)
            .flatMap { b ->
                b.update(request)
                repository.save(b)
    }}

}
