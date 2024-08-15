package com.api.v1.borrower.services

import com.api.v1.annotations.SSN
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.utils.BorrowerFinderUtil
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class DeleteBorrowerBySsnServiceImpl: DeleteBorrowerBySsnService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    @Autowired
    private lateinit var finder: BorrowerFinderUtil

    override fun deleteBySsn(@SSN ssn: String): Mono<Void> {
        return finder.find(ssn).flatMap { b -> Mono.defer { repository.delete(b) } }
    }

}