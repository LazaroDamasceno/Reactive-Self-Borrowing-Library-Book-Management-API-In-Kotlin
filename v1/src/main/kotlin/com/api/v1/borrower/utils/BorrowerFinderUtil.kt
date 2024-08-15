package com.api.v1.borrower.utils

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.exceptions.BorrowerNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class BorrowerFinderUtil {

     @Autowired
     private lateinit var repository: BorrowerRepository

     fun find(ssn: String): Mono<Borrower> {
         return repository
             .getBySsn(ssn)
             .switchIfEmpty(Mono.error(BorrowerNotFoundException()))
     }

}
