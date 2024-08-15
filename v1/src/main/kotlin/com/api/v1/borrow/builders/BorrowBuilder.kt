package com.api.v1.borrow.builders

import com.api.v1.book.domain.Book
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrower.domain.Borrower
import java.time.ZonedDateTime
import java.util.*

class BorrowBuilder {

    private val id: UUID = UUID.randomUUID()
    private lateinit var borrower: Borrower
    private lateinit var book: Book
    private val borrowedDate: String = ZonedDateTime.now().toString()
    private val dueDate: String = ZonedDateTime.now().plusDays(14).toString()

    companion object {
        fun create(): BorrowBuilder {
            return BorrowBuilder()
        }
    }

    fun withBook(book: Book): BorrowBuilder {
        this.book = book
        return this
    }

    fun withBorrower(borrower: Borrower): BorrowBuilder {
        this.borrower = borrower
        return this
    }

    fun build(): Borrow {
        return Borrow(
            id,
            borrower,
            book,
            borrowedDate,
            dueDate
        )
    }

}