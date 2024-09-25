package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.exception.ResourceNotFoundException;
import com.mongodb.crud.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The type Task service.
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * Instantiates a new Task service.
     *
     * @param taskRepository the task repository
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Create task.
     *
     * @param task the task
     */
    public void create(Task task) {
        task.setId(UUID.randomUUID());
        taskRepository.save(task);
    }

    /**
     * Gets all tasks.
     *
     * @return the tasks
     */
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    /**
     * Gets by name.
     *
     * @param name the task
     * @return the by name
     */
    public Task getByName(String name) {
        Task task = taskRepository.findByName(name);

        if (task == null) {
            throw new ResourceNotFoundException("Task with name " + name + " is not found.");
        }

        return task;
    }


    /**
     * Update task.
     *
     * @param targetTaskName the target task name
     * @param taskUpdates    the task updates
     * @return the task
     */
    public Task update(String targetTaskName, Task taskUpdates) {
        Task targetTask = getByName(targetTaskName);
        targetTask.setName(taskUpdates.getName());
        targetTask.setDescription(taskUpdates.getDescription());

        taskRepository.save(targetTask);
        return targetTask;
    }

    /**
     * Delete task.
     *
     * @param name the name
     * @return the task
     */
    public Task delete(String name) {
        Task targetTask = getByName(name);

        taskRepository.deleteById(targetTask.getId());
        return targetTask;
    }
}
