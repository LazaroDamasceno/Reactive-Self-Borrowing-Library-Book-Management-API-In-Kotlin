package com.api.v1.borrower.dtos

import java.time.LocalDate

data class BorrowerResponseDto(
    val fullName: String,
    val ssn: String,
    val birthDate: LocalDate,
    val email: String,
    val address: String,
    val gender: String,
    val phoneNumber: String,
    val createdAt: String,
    val updatedAt: String
)
