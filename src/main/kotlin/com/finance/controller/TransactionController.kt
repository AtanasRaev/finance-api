package com.finance.controller

import com.finance.database.model.dto.WalletTransactionRequestDTO
import com.finance.database.model.dto.WalletTransactionResponseDTO
import com.finance.service.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {

    @PostMapping
    fun create(
        @RequestBody request: WalletTransactionRequestDTO
    ): ResponseEntity<WalletTransactionResponseDTO>{

        val response = transactionService.save(request)

        return ResponseEntity
            .status(201)
            .body(response)
    }
}