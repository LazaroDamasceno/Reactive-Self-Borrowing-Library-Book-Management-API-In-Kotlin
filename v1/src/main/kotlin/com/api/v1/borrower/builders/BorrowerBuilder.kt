package com.api.v1.borrower.builders

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.dtos.NewBorrowerRequestDto
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

class BorrowerBuilder {

    private val id: UUID = UUID.randomUUID()
    private lateinit var firstName: String
    private lateinit var middleName: String
    private lateinit var lastName: String
    private lateinit var ssn: String
    private lateinit var birthDate: LocalDate
    private lateinit var email: String
    private lateinit var address: String
    private lateinit var gender: String
    private lateinit var phoneNumber: String
    private val createdAt: String = ZonedDateTime.now().toString()

    private constructor(dto: NewBorrowerRequestDto) {
        this.firstName = dto.firstName
        this.middleName = dto.middleName
        this.lastName = dto.lastName
        this.ssn = dto.ssn
        this.birthDate = dto.birthDate
        this.email = dto.email
        this.address = dto.address
        this.gender = dto.gender
        this.phoneNumber = dto.phoneNumber
    }


    companion object {
        fun fromDto(dto: NewBorrowerRequestDto): BorrowerBuilder {
            return BorrowerBuilder(dto)
        }
    }

    fun build(): Borrower {
        return Borrower(
            id,
            firstName,
            middleName,
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber,
            createdAt
        )
    }
}
