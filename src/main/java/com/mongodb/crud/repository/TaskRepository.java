package com.mongodb.crud.repository;

import com.mongodb.crud.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TaskRepository extends MongoRepository<Task, String> {

    /**
     * Gets by name.
     *
     * @param name the name
     * @return the by name
     */
    @Query("{name:'?0'}")
    Task getByName(String name);
}
