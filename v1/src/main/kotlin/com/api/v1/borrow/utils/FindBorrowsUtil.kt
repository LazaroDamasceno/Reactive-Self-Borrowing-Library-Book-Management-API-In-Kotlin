package com.api.v1.borrow.utils

import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.domain.BorrowRepository
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import java.time.ZonedDateTime

class FindBorrowsUtil {

    @Autowired
    private lateinit var repository: BorrowRepository

    fun findAll(): Flux<Borrow> {
        return repository.findAll()
    }

    fun findActive(): Flux<Borrow> {
        return repository
            .findAll()
            .filter { e -> e.returnedDate.isEmpty() }
    }

    fun findOverdue(): Flux<Borrow> {
        return repository
            .findAll()
            .filter { e ->
                (
                        ZonedDateTime.parse(e.dueDate) > getToday() ||
                        ZonedDateTime.parse(e.extendedDueDate) > getToday()
                )
                && e.returnedDate.isEmpty()
            }
    }

    private fun getToday(): ZonedDateTime {
        val year = ZonedDateTime.now().year
        val month = ZonedDateTime.now().monthValue
        val day = ZonedDateTime.now().dayOfMonth
        val zone = ZonedDateTime.now().zone
        return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, zone)
    }

    fun findFinished(): Flux<Borrow> {
        return repository
            .findAll()
            .filter { e: Borrow -> e.returnedDate.isNotEmpty() }
    }

}