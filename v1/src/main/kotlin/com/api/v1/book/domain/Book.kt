package com.api.v1.book.domain

import com.api.v1.book.dtos.UpdateBookRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.ZonedDateTime

import java.util.UUID;

@Document(collection = "v1_books")
class Book {

    @Id
    val id: UUID

    @Field
    var title: String

    @Field
    var subtitle: String

    @Field
    var publishingYear: Int

    @Field
    var isbn: String

    @Field
    var publisher: String

    @Field
    var version: Int

    @Field
    var numberOfPages: Int

    @Field
    var author: String

    @Field
    var field: String

    @Field
    val addedAt: String

    @Field
    var updatedAt: String = ""

    constructor(
        id: UUID,
        title: String,
        subtitle: String,
        isbn: String,
        publisher: String,
        publishingYear: Int,
        version: Int,
        numberOfPages: Int,
        author: String,
        field: String,
        addedAt: String
    ) {
        this.id = id
        this.title = title
        this.subtitle = subtitle
        this.isbn = isbn
        this.publisher = publisher
        this.version = version
        this.publishingYear = publishingYear
        this.numberOfPages = numberOfPages
        this.author = author
        this.field = field
        this.addedAt = addedAt
    }

    fun getFullTitle(): String {
        if (subtitle.isEmpty()) return title
        return "$title $subtitle"
    }

    fun update(request: UpdateBookRequestDto) {
        this.title = request.title
        this.subtitle = request.subtitle
        this.publisher = request.publisher
        this.version = request.version
        this.numberOfPages = request.numberOfPages
        this.author = request.author
        this.field = request.field
        this.updatedAt = ZonedDateTime.now().toString()
    }

}