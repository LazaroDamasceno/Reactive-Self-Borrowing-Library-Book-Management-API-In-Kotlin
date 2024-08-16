package com.api.v1.borrow.controllers

import com.api.v1.borrow.services.DeleteAllBorrowsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrows")
internal class DeleteAllBorrowsController {

    @Autowired
    private lateinit var service: DeleteAllBorrowsService

    @DeleteMapping("purging")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteAll(): Mono<Void> {
        return service.deleteAll()
    }

}