package com.mongodb.crud.controller;

import com.mongodb.crud.config.SwaggerConfig;
import com.mongodb.crud.entity.Task;
import com.mongodb.crud.service.TaskService;
import com.mongodb.crud.util.APIResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mongodb.crud.constant.APIResponseConstant.RESOURCES_RETURNED;
import static com.mongodb.crud.constant.APIResponseConstant.RESOURCE_CREATED;
import static com.mongodb.crud.constant.APIResponseConstant.RESOURCE_DELETED;
import static com.mongodb.crud.constant.APIResponseConstant.RESOURCE_FOUND;
import static com.mongodb.crud.constant.APIResponseConstant.RESOURCE_UPDATED;
import static com.mongodb.crud.constant.SwaggerConstant.CONTROLLER_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.CONTROLLER_NAME;
import static java.lang.String.format;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/public/api/v1/tasks")
@Tag(name = CONTROLLER_NAME, description = CONTROLLER_DESCRIPTION)
public class TaskController implements SwaggerConfig {

    private final TaskService taskService;
    private static final String RESOURCE_NAME = Task.class.getSimpleName();

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
    public APIResponse<Task> create(@RequestBody Task task) {
        taskService.create(task);
        return new APIResponse<>(CREATED.value(), format(RESOURCE_CREATED, RESOURCE_NAME), task);
    }

    /**
     * Gets all tasks.
     *
     * @return all tasks within custom api response
     */
    @GetMapping("/")
    public APIResponse<List<Task>> getAll() {
        List<Task> tasks = taskService.getAll();
        return new APIResponse<>(OK.value(), format(RESOURCES_RETURNED, RESOURCE_NAME), tasks);
    }

    /**
     * Gets a task by the name.
     *
     * @param name the name of task
     * @return the task by the name provided within custom api response
     */
    @GetMapping("/{name}/")
    public APIResponse<Task> getByName(@PathVariable String name) {
        Task task = taskService.getByName(name);
        return new APIResponse<>(OK.value(), format(RESOURCE_FOUND, RESOURCE_NAME), task);
    }

    /**
     * Update a task.
     *
     * @param targetTaskName the target task name
     * @param taskUpdates    the task updates
     * @return the updated task within custom api response
     */
    @PatchMapping("/{targetTaskName}/")
    public APIResponse<Task> update(@PathVariable String targetTaskName, @RequestBody Task taskUpdates) {
        Task updatedTask = taskService.update(targetTaskName, taskUpdates);
        return new APIResponse<>(OK.value(), format(RESOURCE_UPDATED, RESOURCE_NAME), updatedTask);
    }

    /**
     * Delete a task.
     *
     * @param name the name of task to delete
     * @return the deleted task within custom api response
     */
    @DeleteMapping("/{name}/")
    public APIResponse<Task> delete(@PathVariable String name) {
        Task deletedTask = taskService.delete(name);
        return new APIResponse<>(OK.value(), format(RESOURCE_DELETED, RESOURCE_NAME), deletedTask);
    }
}
