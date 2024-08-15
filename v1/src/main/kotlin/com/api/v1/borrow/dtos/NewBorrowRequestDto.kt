package com.api.v1.borrow.dtos

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import org.springframework.web.bind.annotation.PathVariable

data class NewBorrowRequestDto(
    @ISBN val isbn: String,
    @SSN val ssn: String
)