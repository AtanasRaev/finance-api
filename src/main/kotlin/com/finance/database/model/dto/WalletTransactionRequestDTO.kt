package com.finance.database.model.dto

data class WalletTransactionRequestDTO(
    var transaction: String,

    var card: String?,

    var merchant: String,

    var amount: String,

    var name: String,
)