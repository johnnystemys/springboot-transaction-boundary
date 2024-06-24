package ch.jdc.springboot_transaction_boundary.todoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoapiApplication

fun main(args: Array<String>) {
	runApplication<TodoapiApplication>(*args)
}
