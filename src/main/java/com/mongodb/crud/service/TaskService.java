package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.mongodb.crud.util.ServiceUtil.validateResourceExists;
import static com.mongodb.crud.util.ServiceUtil.validateResourceNotDuplicated;
import static com.mongodb.crud.util.ServiceUtil.validateResourceNotNull;
import static com.mongodb.crud.util.ServiceUtil.validateStringNotNullOrEmpty;

@Service
public class TaskService {
    private static final String RESOURCE_NAME = Task.class.getSimpleName();
    private static final String FIELD_NAME = "name";

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
        validateResourceNotNull(task, RESOURCE_NAME);

        String taskName = task.getName();
        validateStringNotNullOrEmpty(taskName, RESOURCE_NAME, FIELD_NAME);

        Task result = taskRepository.findByName(taskName);
        validateResourceNotDuplicated(result, RESOURCE_NAME, FIELD_NAME, taskName);

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
     * Gets task by name.
     *
     * @param taskName task name
     * @return the by name
     */
    public Task getByName(String taskName) {
        Task task = taskRepository.findByName(taskName);
        validateResourceExists(task, RESOURCE_NAME, FIELD_NAME, taskName);
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
     * @param taskName task name
     * @return the task
     */
    public Task delete(String taskName) {
        Task targetTask = getByName(taskName);

        taskRepository.deleteById(targetTask.getId());
        return targetTask;
    }
}
