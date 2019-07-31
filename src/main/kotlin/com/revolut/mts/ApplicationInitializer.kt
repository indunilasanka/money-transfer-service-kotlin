package com.revolut.mts

import com.revolut.mts.configuration.`DatabaseFactory.kt`
import com.revolut.mts.controller.`MoneyTransferController.kt`
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main(args: Array<String>) {
    `DatabaseFactory.kt`.initializeConnection()
    val app = Javalin.create {}.start(7000)

    app.routes {
        get("/", { ctx -> ctx.redirect("/users") })
        path("users") {
            get(`MoneyTransferController.kt`::getAllUserIds)
            post(`MoneyTransferController.kt`::createUser)
            path(":user-id") {
                get(`MoneyTransferController.kt`::getUser)
                patch(`MoneyTransferController.kt`::updateUser)
                delete(`MoneyTransferController.kt`::deleteUser)
            }
        }
    }
}


