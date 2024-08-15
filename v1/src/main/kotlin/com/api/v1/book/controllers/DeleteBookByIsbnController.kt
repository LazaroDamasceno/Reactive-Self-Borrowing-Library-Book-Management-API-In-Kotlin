package com.api.v1.book.controllers

import com.api.v1.annotations.ISBN
import com.api.v1.book.services.DeleteBookByIsbnService
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class DeleteBookByIsbnController {

    @Autowired
    private lateinit var service: DeleteBookByIsbnService

    @DeleteMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteByIsbn(@ISBN @PathVariable isbn: String): Mono<Void> {
        return service.deleteByIsbn(isbn);
    }

}