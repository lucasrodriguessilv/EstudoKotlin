package com.example.user

class UserService {

    fun findAll(): List<User> = users

    private val users = mutableListOf(
        User(1, "Lucas", "lucas@email.com"),
        User(2, "Maria", "maria@email.com")
    )

    fun findById(id: Int): User? {
        return users.find { it.id == id }
    }

    fun create(user: User): User {
        users.add(user)
        return user
    }

    fun delete(id: Int): Boolean {
        return users.removeIf { it.id == id }
    }
}