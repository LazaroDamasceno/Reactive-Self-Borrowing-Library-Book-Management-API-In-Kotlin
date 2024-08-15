package com.api.v1.borrower.dtos

import com.api.v1.annotations.SSN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class NewBorrowerRequestDto(
    @NotBlank val firstName: String,
    val middleName: String,
    @NotBlank val lastName: String,
    @SSN val ssn: String,
    @NotNull val birthDate: LocalDate,
    @NotBlank @Email val email: String,
    @NotBlank val address: String,
    @NotNull @Size(min=1) val gender: String,
    @NotNull @Size(min=10, max=10) val phoneNumber: String
)
