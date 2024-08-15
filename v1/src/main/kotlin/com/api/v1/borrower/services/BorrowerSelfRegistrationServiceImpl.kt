package com.api.v1.borrower.services

import com.api.v1.borrower.builders.BorrowerBuilder
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.dtos.BorrowerResponseDto
import com.api.v1.borrower.dtos.NewBorrowerRequestDto
import com.api.v1.borrower.mappers.BorrowerResponseMapper
import com.api.v1.borrower.exceptions.DuplicatedSsnException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
internal class BorrowerSelfRegistrationServiceImpl: BorrowerSelfRegistrationService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    override fun selfRegister(request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        return repository
            .getBySsn(request.ssn)
            .hasElement()
            .flatMap { exists ->
                if (exists) duplicatedSsnError()
                else defer(request)
            }
    }

    private fun duplicatedSsnError(): Mono<BorrowerResponseDto> {
        val message = "Ssn is already used by another borrower.";
        return Mono.error(DuplicatedSsnException(message))
    }

    private fun defer(request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        return Mono.defer {
            val borrower: Borrower = BorrowerBuilder.fromDto(request).build()
            val savedBorrower = repository.save(borrower)
            savedBorrower.flatMap { b -> Mono.just(BorrowerResponseMapper.map(b)) }
    }}

}