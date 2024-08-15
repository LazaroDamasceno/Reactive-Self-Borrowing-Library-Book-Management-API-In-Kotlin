package com.api.v1.borrow.dtos

import com.api.v1.book.domain.Book
import com.api.v1.borrower.domain.Borrower

data class BorrowResponseDto(
    val borrower: Borrower,
    val book: Book,
    val borrowedDate: String,
    val dueDate: String,
    val extendedDueDate: String,
    val returnedDate: String
)
