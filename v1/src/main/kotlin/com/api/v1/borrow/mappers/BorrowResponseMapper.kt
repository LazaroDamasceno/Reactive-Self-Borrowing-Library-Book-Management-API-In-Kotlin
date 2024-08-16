package com.api.v1.borrow.mappers

import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.dtos.BorrowResponseDto

class BorrowResponseMapper {

    companion object {
        fun map(borrow: Borrow): BorrowResponseDto {
            return BorrowResponseDto(
                BorrowResponseMapper.map(borrow.borrower),
                BookResponseMapper.map(borrow.book),
                borrow.borrowedDate,
                borrow.dueDate,
                borrow.extendedDueDate,
                borrow.returnedDate
            )
        }
    }

}