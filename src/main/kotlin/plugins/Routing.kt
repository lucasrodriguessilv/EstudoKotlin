package com.example

import com.example.user.userRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondText("API rodando 🚀")
        }

        userRoutes()
    }
}