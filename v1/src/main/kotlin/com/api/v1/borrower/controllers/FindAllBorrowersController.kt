package com.api.v1.borrower.controllers

import com.api.v1.borrower.dtos.BorrowerResponseDto
import com.api.v1.borrower.services.FindAllBorrowersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/v1/borrowers")
internal class FindAllBorrowersController {

    @Autowired
    private lateinit var service: FindAllBorrowersService


    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    fun findAll(): Flux<BorrowerResponseDto> {
        return service.findAll()
    }

}