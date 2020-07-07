package com.briandev.springvaadin.controllers


import com.briandev.springvaadin.backend.models.Tasks
import com.briandev.springvaadin.backend.services.TaskService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/")
class RestController(private val tasksService: TaskService) {

    @GetMapping("/tasks")
    fun allTasks() = tasksService.getTasks()

    @PostMapping("/tasks/new")
    fun newTask(@Valid @RequestBody task : Tasks) = tasksService.createTask(task)

    @GetMapping("/tasks/{id}")
    fun singleTask(@PathVariable(value = "id") taskId: Long) = tasksService.getTaskById(taskId)

    @PutMapping("/tasks/{id}/update")
    fun updateTask(
            @PathVariable(value = "id") taskId: Long,
            @Valid @RequestBody newTasks: Tasks
    ) = tasksService.putTasks(taskId, task = newTasks)

    @DeleteMapping("/tasks/{id}/delete")
    fun deleteTask(
            @PathVariable(value = "id") taskId: Long
    ) = tasksService.deleteTask(taskId)
}