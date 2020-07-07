package com.briandev.springvaadin.backend.services

import com.briandev.springvaadin.backend.models.Tasks
import com.briandev.springvaadin.backend.repositories.taskRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TaskService (private val taskRepo: taskRepo) {

    fun getTasks(): List<Tasks> = taskRepo.findAll()
    fun createTask(task: Tasks) = ResponseEntity.ok(taskRepo.save(task))
    fun getTaskById(id: Long) : ResponseEntity<Tasks> = taskRepo.findById(id).map {
        ResponseEntity.ok(it)
    }.orElse(ResponseEntity.notFound().build())
    fun putTasks(taskId: Long, task: Tasks) : ResponseEntity<Tasks> = taskRepo.findById(taskId).map {
        val updatedTask = it.copy(
            title = task.title,
            description = task.description,
            status = task.status,
            dueDate = task.dueDate,
            startDate = task.startDate,
            priority = task.priority
        )
        ResponseEntity.ok().body(taskRepo.save(updatedTask))
    }.orElse(ResponseEntity.notFound().build())

    fun deleteTask(taskId: Long): ResponseEntity<Void> = taskRepo.findById(taskId).map {
        taskRepo.delete(it)
        ResponseEntity<Void>(HttpStatus.ACCEPTED)
    }.orElse(ResponseEntity.notFound().build())
}