package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * Gets all.
     *
     * @return the all
     */
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    /**
     * Gets by name.
     *
     * @param task the task
     * @return the by name
     */
    public String getByName(String task) {
        return taskRepository.getByName(task).getName().toLowerCase();

    }

    /**
     * Create task.
     *
     * @param task the task
     */
    public void createTask(Task task) {
        taskRepository.save(task);
    }


}
