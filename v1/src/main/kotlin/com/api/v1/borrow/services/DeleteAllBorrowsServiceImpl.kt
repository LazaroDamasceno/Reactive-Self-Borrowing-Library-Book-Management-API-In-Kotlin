package com.api.v1.borrow.services

import com.api.v1.borrow.domain.BorrowRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class DeleteAllBorrowsServiceImpl: DeleteAllBorrowsService {

    @Autowired
    private lateinit var repository: BorrowRepository

    override fun deleteAll(): Mono<Void> {
        return repository.deleteAll();
    }

}