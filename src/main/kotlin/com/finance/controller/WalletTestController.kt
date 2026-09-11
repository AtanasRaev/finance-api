package com.finance.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class WalletTestController {

    @PostMapping("/wallet")
    fun wallet(
        @RequestBody body: Map<String, Any?>
    ): Map<String, Any?> {

        println("=== WALLET PAYLOAD ===")
        body.forEach { (key, value) ->
            println("$key = $value")
        }
        println("======================")

        return body
    }
}