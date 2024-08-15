package com.api.v1.borrower.controllers

import com.api.v1.borrower.services.DeleteAllBorrowersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrowers")
internal class DeleteAllBorrowerController {

    @Autowired
    private lateinit var service: DeleteAllBorrowersService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public fun deleteAll(): Mono<Void> {
        return service.deleteAll()
    }

}