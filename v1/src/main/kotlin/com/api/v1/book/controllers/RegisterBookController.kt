package com.api.v1.book.controllers

import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.dtos.NewBookRequestDto
import com.api.v1.book.services.RegisterBookService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/books")
class RegisterBookController {

    @Autowired
    private lateinit var service: RegisterBookService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun register(@Valid @RequestBody request: NewBookRequestDto): Mono<BookResponseDto> {
        return service.register(request)
    }

}