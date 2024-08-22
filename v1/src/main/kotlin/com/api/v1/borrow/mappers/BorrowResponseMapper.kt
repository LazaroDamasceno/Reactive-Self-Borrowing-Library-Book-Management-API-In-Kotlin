package com.api.v1.borrow.mappers

import com.api.v1.book.mappers.BookResponseMapper
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrower.mappers.BorrowerResponseMapper

class BorrowResponseMapper {

    companion object {
        fun map(borrow: Borrow): BorrowResponseDto {
            return BorrowResponseDto(
                BorrowerResponseMapper.map(borrow.borrower),
                BookResponseMapper.map(borrow.book),
                borrow.borrowedDate,
                borrow.dueDate,
                borrow.extendedDueDate,
                borrow.returnedDate
            )
        }
    }

}