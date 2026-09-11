package com.finance.database.repository

import com.finance.database.model.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionRepository : JpaRepository<TransactionEntity, UUID> {
}