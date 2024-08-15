package com.api.v1.borrow.domain

import com.api.v1.borrower.domain.Borrower
import com.api.v1.book.domain.Book
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.ZonedDateTime
import java.util.*

@Document(collection = "v1_borrows")
class Borrow {

    @Id
    val id: UUID

    @Field
    val borrower: Borrower

    @Field
    val book: Book

    @Field
    val borrowedDate: String

    @Field
    val dueDate: String

    @Field
    var extendedDueDate: String = ""

    @Field
    var returnedDate: String = ""

    constructor(
        id: UUID,
        borrower: Borrower,
        book: Book,
        borrowedDate: String,
        dueDate: String
    ) {
        this.id = id
        this.borrower = borrower
        this.book = book
        this.borrowedDate = borrowedDate
        this.dueDate = dueDate
    }

    fun extendDueDate() {
        extendedDueDate = ZonedDateTime.parse(dueDate).plusDays(14).toString()
    }

    fun finishBorrow() {
        returnedDate = ZonedDateTime.now().toString()
    }

}