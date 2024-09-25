package com.mongodb.crud.controller;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.service.TaskService;
import com.mongodb.crud.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    /**
     * Instantiates a new Task controller.
     *
     * @param taskService the task service
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a task.
     *
     * @param task the task to be saved to database
     * @return the created task within custom api response
     */
    @PostMapping("/")
    public ApiResponse<Task> create(@RequestBody Task task) {
        taskService.create(task);
        return new ApiResponse<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), task);
    }

    /**
     * Gets all tasks.
     *
     * @return all tasks within custom api response
     */
    @GetMapping("/")
    public ApiResponse<List<Task>> getAll() {
        List<Task> tasks = taskService.getAll();
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), tasks);
    }

    /**
     * Gets a task by the name.
     *
     * @param name the name of task
     * @return the task by the name provided within custom api response
     */
    @GetMapping("/{name}/")
    public ApiResponse<Task> getByName(@PathVariable String name) {
        Task task = taskService.getByName(name);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), task);
    }

    /**
     * Update a task.
     *
     * @param targetTaskName the target task name
     * @param taskUpdates    the task updates
     * @return the updated task within custom api response
     */
    @PatchMapping("/{targetTaskName}/")
    public ApiResponse<Task> update(@PathVariable String targetTaskName, @RequestBody Task taskUpdates) {
        Task updatedTask = taskService.update(targetTaskName, taskUpdates);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), updatedTask);
    }

    /**
     * Delete a task.
     *
     * @param name the name of task to delete
     * @return the deleted task within custom api response
     */
    @DeleteMapping("/{name}/")
    public ApiResponse<Task> delete(@PathVariable String name) {
        Task deletedTask = taskService.delete(name);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), deletedTask);
    }
}
