package com.finance.service

import com.finance.database.model.dto.WalletTransactionRequestDTO
import com.finance.database.model.dto.WalletTransactionResponseDTO

interface TransactionService {
    fun save(request: WalletTransactionRequestDTO) : WalletTransactionResponseDTO
}