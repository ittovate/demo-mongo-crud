package com.mongodb.crud.repository;

import com.mongodb.crud.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TaskRepository extends MongoRepository<Task,String> {

    @Query("{taskName:'?0'}")
    public Task GetByName(String name);
//
//    public List<Task> GetAll();
}