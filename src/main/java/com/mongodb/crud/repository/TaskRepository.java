package com.mongodb.crud.repository;

import com.mongodb.crud.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> {

    /**
     * Gets task by the name.
     *
     * @param name the name
     * @return the by name
     */
    @Query("{name:'?0'}")
    Task findByName(String name);
}
