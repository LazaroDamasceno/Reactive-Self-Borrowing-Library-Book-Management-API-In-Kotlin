package com.api.v1.annotations

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@NotNull
@Size(min = 13, max = 13)
annotation class ISBN(val message: String = "Invalid ISBN format. Please enter a 13-digit ISBN.")