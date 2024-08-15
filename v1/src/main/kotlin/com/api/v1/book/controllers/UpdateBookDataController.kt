package com.api.v1.book.controllers

import com.api.v1.annotations.ISBN
import com.api.v1.book.domain.Book
import com.api.v1.book.dtos.UpdateBookRequestDto
import com.api.v1.book.services.UpdateBookDataService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class UpdateBookDataController {

    @Autowired
    private lateinit var service: UpdateBookDataService

    @PutMapping("{isbn}")
    fun update(
        @ISBN @PathVariable isbn: String,
        @Valid @RequestBody request: UpdateBookRequestDto
    ): Mono<Book> {
        return service.update(isbn, request)
    }

}