package com.api.v1.borrow.controllers

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.borrow.services.DeleteBorrowService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrows")
internal class DeleteBorrowController {

    @Autowired
    private lateinit var service: DeleteBorrowService

    @DeleteMapping("by-book/{isbn}/and/by-borrower/{ssn}/purging")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@ISBN @PathVariable isbn: String, @SSN @PathVariable  ssn: String): Mono<Void> {
        return service.delete(isbn, ssn)
    }

}