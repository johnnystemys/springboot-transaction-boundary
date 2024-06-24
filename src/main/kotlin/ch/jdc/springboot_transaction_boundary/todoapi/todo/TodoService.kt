package ch.jdc.springboot_transaction_boundary.todoapi.todo

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TodoService (
    val todoRepo: TodoRepository
) {
    @Transactional
    fun findAll(): List<TodoEntity> {
        return todoRepo.findAll()
    }


    @Transactional
    fun create(title: String): TodoEntity {
        val todo = TodoEntity(title = title)
        return todoRepo.save(todo)
    }

    @Transactional
    fun delete(id: Long, throwEx: Boolean? = false) {
        todoRepo.deleteById(id)
        if (throwEx == true) {
            throw IllegalArgumentException("Cannot delete the todo item")
        }
    }

    fun badDelete(id: Long) {
        this.delete(id, true)
    }

    @Transactional
    fun done(id: Long) : TodoEntity {
        val todo = todoRepo.findById(id).orElseThrow { IllegalArgumentException("Todo not found") }
        todo.done = true
        return todoRepo.save(todo)
    }

    @Transactional
    fun undone(id: Long) {
        val todo = todoRepo.findById(id).orElseThrow { IllegalArgumentException("Todo not found") }
        todo.done = false
        todoRepo.save(todo)
    }
}
