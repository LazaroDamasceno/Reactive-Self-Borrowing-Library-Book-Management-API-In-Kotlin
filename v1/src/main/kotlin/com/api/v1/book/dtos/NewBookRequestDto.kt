package com.api.v1.book.dtos

import com.api.v1.annotations.ISBN
import jakarta.validation.constraints.*

data class NewBookRequestDto(
    @NotBlank val title: String,
    val subtitle: String,
    @ISBN val isbn: String,
    @NotBlank val publisher: String,
    val publishingYear: Int,
    @Min(1) val version: Int,
    @NotEmpty val numberOfPages: Int,
    @NotBlank val author: String,
    @NotBlank val field: String
)
