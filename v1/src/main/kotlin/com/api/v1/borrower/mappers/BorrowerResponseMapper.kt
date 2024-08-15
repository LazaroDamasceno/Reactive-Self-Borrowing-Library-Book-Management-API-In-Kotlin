package com.api.v1.borrower.mappers

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.dtos.BorrowerResponseDto

class BorrowerResponseMapper {

    companion object {
        fun map(borrower: Borrower): BorrowerResponseDto {
            return BorrowerResponseDto(
                borrower.getFullName(),
                borrower.ssn,
                borrower.birthDate,
                borrower.email,
                borrower.address,
                borrower.gender,
                borrower.phoneNumber,
                borrower.createdAt,
                borrower.updatedAt
            )
        }
    }

}