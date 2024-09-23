package com.mongodb.crud.controller;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getAll(){
       return taskService.GetAll();
    }

    @GetMapping("/{task}")
    public String getByName(@PathVariable String task){
        return taskService.GetByName(task);
    }

    @PostMapping("/")
    public void addTask(@RequestBody Task task){
         taskService.CreateTask(task);
    }
}