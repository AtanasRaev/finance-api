package com.finance.database.model.dto

import java.time.Instant

data class WalletTransactionResponseDTO(
    val transaction: String,
    val amount: String,
    val merchant: String?,
    val card: String?,
    val createdAt: Instant
)