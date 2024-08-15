package com.api.v1.book.controllers

import com.api.v1.book.services.DeleteAllBooksService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class DeleteAllBooksController {

    @Autowired
    private lateinit var service: DeleteAllBooksService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteAll(): Mono<Void> {
        return service.deleteAll()
    }

}