package com.revolut.mts.model

import org.jetbrains.exposed.sql.Table

object Transactions : Table() {
    val accountId = integer("account_id").primaryKey().autoIncrement()
    val accountHolder = varchar("account_holder", 255)
    val balance = decimal("balance", 2, 20)
}


data class Transaction(
        val accountId: Int,
        val accountHolder: String,
        val balance: Double
)


data class NewTransaction(
        val accountId: Int,
        val accountHolder: String,
        val balance: Double
)
