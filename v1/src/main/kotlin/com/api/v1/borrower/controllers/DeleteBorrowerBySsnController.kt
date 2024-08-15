package com.api.v1.borrower.controllers

import com.api.v1.annotations.SSN
import com.api.v1.borrower.services.DeleteBorrowerBySsnService
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
@RequestMapping("api/v1/borrowers")
internal class DeleteBorrowerBySsnController {

    @Autowired
    private lateinit var service: DeleteBorrowerBySsnService

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteBySsn(@SSN @PathVariable ssn: String): Mono<Void> {
        return service.deleteBySsn(ssn);
    }

}