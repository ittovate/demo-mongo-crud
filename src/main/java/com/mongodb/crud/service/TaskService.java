package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> GetAll(){
//        return taskRepository.GetAll();
        return taskRepository.findAll();
    }

    public String GetByName (String task){
       return taskRepository.GetByName(task).getTaskName().toLowerCase();

    }

    public void CreateTask (Task task){
        taskRepository.save(task);
    }


}