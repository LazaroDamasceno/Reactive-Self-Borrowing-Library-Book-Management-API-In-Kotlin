package com.api.v1.annotations

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@NotNull
@Size(min = 9, max = 9)
annotation class SSN(val message: String = "Invalid SSN format. Please enter a 9-digit Social Security Number.")
