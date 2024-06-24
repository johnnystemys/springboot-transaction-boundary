package ch.jdc.springboot_transaction_boundary.todoapi.todo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<TodoEntity, Long> {
    fun findByTitle(title: String): TodoEntity?
}
