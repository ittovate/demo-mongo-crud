package com.mongodb.crud.controller;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
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
     * Gets all tasks.
     *
     * @return the tasks
     */
    @GetMapping("/")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    /**
     * Gets task by name.
     *
     * @param name the name of task
     * @return the task by the name provided
     */
    @GetMapping("/{name}")
    public String getByName(@PathVariable String name) {
        return taskService.getByName(name);
    }

    /**
     * Add new task.
     *
     * @param task the task to be created
     */
    @PostMapping("/")
    public void addTask(@RequestBody Task task) {
        taskService.createTask(task);
    }
}
