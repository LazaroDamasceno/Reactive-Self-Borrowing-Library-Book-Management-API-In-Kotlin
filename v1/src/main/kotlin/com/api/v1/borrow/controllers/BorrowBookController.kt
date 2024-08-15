package com.api.v1.borrow.controllers

import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.dtos.NewBorrowRequestDto
import com.api.v1.borrow.services.BorrowBookServiceImpl
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrows")
internal class BorrowBookController {

    @Autowired
    private lateinit var service: BorrowBookServiceImpl

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun borrow(@Valid @RequestBody request: NewBorrowRequestDto): Mono<BorrowResponseDto> {
        return service.borrow(request)
    }

}