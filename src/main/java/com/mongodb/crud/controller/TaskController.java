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
@RequestMapping("/public/api/tasks")
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
     * Create api response.
     *
     * @param task the task
     * @return the api response
     */
    @PostMapping("/")
    public ApiResponse<Task> create(@RequestBody Task task) {
        taskService.create(task);
        return new ApiResponse<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), task);
    }

    /**
     * Gets all tasks.
     *
     * @return the tasks
     */
    @GetMapping("/")
    public ApiResponse<List<Task>> getAll() {
        List<Task> tasks = taskService.getAll();
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), tasks);
    }

    /**
     * Gets task by name.
     *
     * @param name the name of task
     * @return the task by the name provided
     */
    @GetMapping("/{name}/")
    public ApiResponse<Task> getByName(@PathVariable String name) {
        Task task = taskService.getByName(name);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), task);
    }

    /**
     * Update task.
     *
     * @param targetTaskName the target task name
     * @param taskUpdates    the task updates
     * @return the api response
     */
    @PatchMapping("/{targetTaskName}/")
    public ApiResponse<Task> update(@PathVariable String targetTaskName, @RequestBody Task taskUpdates) {
        Task updatedTask = taskService.update(targetTaskName, taskUpdates);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), updatedTask);
    }

    /**
     * Delete task.
     *
     * @param name the name
     * @return the api response
     */
    @DeleteMapping("/{name}/")
    public ApiResponse<Task> delete(@PathVariable String name) {
        Task deletedTask = taskService.delete(name);
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), deletedTask);
    }
}
