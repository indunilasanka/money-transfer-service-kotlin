package com.revolut.mts.controller

import io.javalin.http.Context
import java.util.*

object `MoneyTransferController.kt` {

    private data class User(val name: String = "", val email: String = "")

    private val users = hashMapOf(
            randomId() to User(name = "Alice", email = "alice@alice.kt"),
            randomId() to User(name = "Bob", email = "bob@bob.kt"),
            randomId() to User(name = "Carol", email = "carol@carol.kt"),
            randomId() to User(name = "Dave", email = "dave@dave.kt")
    )

    fun getAllUserIds(ctx: Context) {
        ctx.json(users.keys)
    }

    fun createUser(ctx: Context) {
        users[randomId()] = ctx.bodyAsClass(User::class.java)
    }

    fun getUser(ctx: Context) {
        ctx.json(users[ctx.pathParam(":user-id")]!!)
    }

    fun updateUser(ctx: Context) {
        users[ctx.pathParam(":user-id")] = ctx.bodyAsClass(User::class.java)
    }

    fun deleteUser(ctx: Context) {
        users.remove(ctx.pathParam(":user-id"))
    }

    private fun randomId() = UUID.randomUUID().toString()

}
