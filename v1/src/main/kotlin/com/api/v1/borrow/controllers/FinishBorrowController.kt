package com.api.v1.borrow.controllers

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.services.FinishBorrowServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrows")
internal class FinishBorrowController {

    @Autowired
    private lateinit var service: FinishBorrowServiceImpl

    @PatchMapping("finish/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun finish(@ISBN @PathVariable isbn: String, @SSN @PathVariable ssn: String): Mono<Borrow> {
        return service.finish(isbn, ssn)
    }

}