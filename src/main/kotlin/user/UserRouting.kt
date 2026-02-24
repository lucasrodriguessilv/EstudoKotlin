package com.example.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoutes() {

    val service = UserService()

    route("/users") {

        get {
            call.respond(service.findAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond("Invalid ID")
                return@get
            }

            val user = service.findById(id)

            if (user == null) {
                call.respond("User not found")
            } else {
                call.respond(user)
            }
        }

        post {
            val user = call.receive<User>()
            call.respond(service.create(user))
        }

        delete("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond("Invalid ID")
                return@delete
            }

            val deleted = service.delete(id)

            if (deleted) {
                call.respond("User deleted")
            } else {
                call.respond("User not found")
            }
        }
    }
}