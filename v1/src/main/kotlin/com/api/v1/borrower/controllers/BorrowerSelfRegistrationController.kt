package com.api.v1.borrower.controllers

import com.api.v1.borrower.dtos.BorrowerResponseDto
import com.api.v1.borrower.dtos.NewBorrowerRequestDto
import com.api.v1.borrower.services.BorrowerSelfRegistrationService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrowers")
internal class BorrowerSelfRegistrationController {

    @Autowired
    private lateinit var service: BorrowerSelfRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun selfRegister(@Valid @RequestBody request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        return service.selfRegister(request)
    }

}