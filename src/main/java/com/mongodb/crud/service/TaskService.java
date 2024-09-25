package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.exception.DuplicateResourceException;
import com.mongodb.crud.exception.ResourceNotFoundException;
import com.mongodb.crud.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_ALREADY_EXIST;
import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_FIELD_CANNOT_BE_NULL_OR_EMPTY;
import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_NOT_FOUND;
import static java.lang.String.format;

/**
 * The type Task service.
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final String resourceName = Task.class.getSimpleName();

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

        String taskName = task.getName();

        if (taskName == null || taskName.trim().isEmpty()) {
            throw new IllegalArgumentException(format(RESOURCE_FIELD_CANNOT_BE_NULL_OR_EMPTY, resourceName, "name"));
        }

        Task existingTask = getByName(taskName);
        if (existingTask != null) {
            throw new DuplicateResourceException(format(RESOURCE_ALREADY_EXIST, resourceName, "name", taskName));
        }

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
            throw new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, resourceName, "name", name));
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
