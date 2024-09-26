package com.mongodb.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document("task")
public class Task {
    @Id
    private UUID id;
    private String name;
    private String description;

    public Task() {

    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
