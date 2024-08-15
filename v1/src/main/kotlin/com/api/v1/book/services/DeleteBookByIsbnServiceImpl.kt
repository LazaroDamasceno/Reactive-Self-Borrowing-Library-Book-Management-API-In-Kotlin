package com.api.v1.book.services

import com.api.v1.annotations.ISBN
import com.api.v1.book.domain.BookRepository
import com.api.v1.book.utils.BookFinderUtil
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class DeleteBookByIsbnServiceImpl: DeleteBookByIsbnService {

    @Autowired
    private lateinit var repository: BookRepository

    @Autowired
    private lateinit var finder: BookFinderUtil

    override fun deleteByIsbn(@ISBN isbn: String): Mono<Void> {
        return finder.find(isbn).flatMap {
            b -> repository.delete(b)
        }
    }

}