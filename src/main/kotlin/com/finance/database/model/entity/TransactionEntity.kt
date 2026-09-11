package com.finance.database.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.UUID
import java.time.Instant

@Entity
@Table(name = "transactions")
class TransactionEntity(

    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "transaction_raw", nullable = false)
    var transaction: String,

    @Column(name = "card_raw")
    var card: String?,

    @Column(name = "merchant_raw", nullable = false)
    var merchant: String,

    @Column(name = "amount_raw", nullable = false)
    var amount: String,

    @Column(name = "name_raw", nullable = false)
    var name: String,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload", columnDefinition = "jsonb", nullable = false)
    var rawPayload: String,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant = Instant.now()
)
