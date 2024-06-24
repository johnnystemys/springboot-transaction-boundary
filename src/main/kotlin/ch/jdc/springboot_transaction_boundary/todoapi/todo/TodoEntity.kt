package ch.jdc.springboot_transaction_boundary.todoapi.todo

import jakarta.persistence.*

@Entity
class TodoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long?= null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var done : Boolean = false
)
