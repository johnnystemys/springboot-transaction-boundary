package ch.jdc.springboot_transaction_boundary.todoapi.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * this controller is used to demonstrate the transaction boundary
 * it didn't respect the restful standard and is only used for demonstration purposes
 */
@RestController("/todos")
class TodoController(
    val transactionService: TodoService
) {

    @GetMapping("/")
    fun findAll(): List<TodoEntity> {
        return transactionService.findAll()
    }

    @GetMapping("/new/{title}")
    fun create(@PathVariable("title") title: String): TodoEntity {
        return transactionService.create(title)
    }

    @GetMapping("/done/{id}")
    fun done(@PathVariable("id") id: Long): TodoEntity {
        return transactionService.done(id)
    }

    @GetMapping("/undone/{id}")
    fun undone(@PathVariable("id") id: Long) {
        transactionService.undone(id)
    }

    @GetMapping("/badDelete/{id}")
    fun badDelete(@PathVariable("id") id: Long) {
        transactionService.badDelete(id)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long, @RequestParam("throwEx") throwEx: Boolean? = false){
        transactionService.delete(id, throwEx)
    }
}
