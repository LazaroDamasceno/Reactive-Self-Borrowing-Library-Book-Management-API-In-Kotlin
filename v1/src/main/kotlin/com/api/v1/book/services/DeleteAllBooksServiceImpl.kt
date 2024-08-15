package com.api.v1.book.services

import com.api.v1.book.domain.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class DeleteAllBooksServiceImpl: DeleteAllBooksService {

    @Autowired
    private lateinit var repository: BookRepository

    override fun deleteAll(): Mono<Void> {
        return repository.deleteAll()
    }

}