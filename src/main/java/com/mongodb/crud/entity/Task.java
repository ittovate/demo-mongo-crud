package com.mongodb.crud.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("tasks")
public class Task {

    @Id
    @CreatedDate
    @LastModifiedBy
    @LastModifiedDate
    private String id;

    @LastModifiedBy
    @LastModifiedDate
    private String name;

    @LastModifiedBy
    @LastModifiedDate
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
