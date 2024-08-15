package com.api.v1.borrower.services

import com.api.v1.borrower.domain.BorrowerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class DeleteAllBorrowersServiceImpl: DeleteAllBorrowersService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    override fun deleteAll(): Mono<Void> {
        return repository.deleteAll();
    }

}