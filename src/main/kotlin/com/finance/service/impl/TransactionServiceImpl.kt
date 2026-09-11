package com.finance.service.impl

import com.finance.database.model.dto.WalletTransactionRequestDTO
import com.finance.database.model.dto.WalletTransactionResponseDTO
import com.finance.database.model.entity.TransactionEntity
import com.finance.database.repository.TransactionRepository
import com.finance.service.TransactionService
import org.springframework.stereotype.Service
import tools.jackson.databind.ObjectMapper

@Service
class TransactionServiceImpl(
    private val transactionRepository: TransactionRepository,
    private val objectMapper: ObjectMapper
) : TransactionService {

    override fun save(
        request: WalletTransactionRequestDTO
    ): WalletTransactionResponseDTO {

        val entity = TransactionEntity(
            transaction = request.transaction,
            card = request.card,
            merchant = request.merchant,
            amount = request.amount,
            name = request.name,
            rawPayload = objectMapper.writeValueAsString(request)
        )

        val saved = transactionRepository.save(entity)

        return WalletTransactionResponseDTO(
            transaction = saved.transaction,
            amount = saved.amount,
            merchant = saved.merchant,
            card = saved.card,
            createdAt = saved.createdAt
        )
    }
}