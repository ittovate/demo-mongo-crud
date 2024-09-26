package com.mongodb.crud.constant;

public final class SwaggerConstant {
    public static final String TITLE = "Task API";
    public static final String VERSION = "1.0";
    public static final String DESCRIPTION = "Task API for CRUD Operations with MongoDB.";
    public static final String CONTACT_NAME = "ittovate";
    public static final String CONTACT_URL = "https://github.com/orgs/ittovate/";

    //================================================= Create Task =================================================//
    public static final String CREATE_TASK_SUMMARY = "Create task";
    public static final String CREATE_TASK_DESCRIPTION = "Create and save task to database.";
    public static final String CREATE_TASK_REQUEST_BODY_DESCRIPTION = "Task name cannot be null, empty, or duplicated.";
    public static final String CREATE_TASK_REQUEST_BODY_EXAMPLE = """
            {
                "name": "task1",
                "description": "This is task 1 description"
            }
            """;
    public static final String TASK_CREATED_RESPONSE_DESCRIPTION = "When task is created successfully.";
    public static final String TASK_CREATED_RESPONSE_EXAMPLE = """
            {
                "statusCode": 201,
                "message": "Task created successfully!",
                "timestamp": "2024-09-26T17:41:20.1219751",
                "body": {
                    "id": "bbd393c6-7224-4a17-9e04-9da09cbd9f46",
                    "name": "task1",
                    "description": "This is task 1 description"
                }
            }
            """;
    public static final String INVALID_TASK_RESPONSE_DESCRIPTION = "When task name is null or empty.";
    public static final String INVALID_TASK_RESPONSE_EXAMPLE = """
            {
                "statusCode": 400,
                "message": "Task name cannot be null or empty!",
                "timestamp": "2024-09-26T18:37:00.2743049",
                "body": null
            }
            """;
    public static final String DUPLICATED_TASK_RESPONSE_DESCRIPTION = "When task already exists.";
    public static final String DUPLICATED_TASK_RESPONSE_EXAMPLE = """
            {
                "statusCode": 409,
                "message": "Task with name `task1` already exists!",
                "timestamp": "2024-09-26T18:53:50.4791241",
                "body": null
            }
            """;

    //================================================ Get All Tasks ================================================//
    public static final String GET_ALL_TASKS_SUMMARY = "Get all tasks";
    public static final String GET_ALL_TASKS_DESCRIPTION = "Get all tasks from database.";
    public static final String GET_ALL_TASKS_RESPONSE_DESCRIPTION = "When all tasks are returned.";
    public static final String GET_ALL_TASKS_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "All Tasks are returned!",
                "timestamp": "2024-09-26T20:16:45.3482481",
                "body": [
                    {
                        "id": "a5443f59-55ea-4d6e-b287-c013f1921dca",
                        "name": "task1",
                        "description": "This is task 1 description"
                    },
                    {
                        "id": "fccc4417-f8df-4e0f-94ed-437ab0fdb8ba",
                        "name": "task2",
                        "description": "This is task 2 description"
                    },
                    {
                        "id": "c3826343-ed93-4e50-867d-fea50c340676",
                        "name": "task3",
                        "description": "This is task 3 description"
                    }
                ]
            }
            """;

    //================================================ Get One Task ================================================//
    public static final String GET_TASK_SUMMARY = "Get one task";
    public static final String GET_TASK_DESCRIPTION = "Get one task by name from database.";
    public static final String GET_TASK_RESPONSE_DESCRIPTION = "When task is found.";
    public static final String GET_TASK_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "Task found!",
                "timestamp": "2024-09-26T21:28:38.6668571",
                "body": {
                    "id": "a5443f59-55ea-4d6e-b287-c013f1921dca",
                    "name": "task1",
                    "description": "This is task 1 description"
                }
            }
            """;
    public static final String TASK_NOT_FOUND_RESPONSE_DESCRIPTION = "When task is not found.";
    public static final String TASK_NOT_FOUND_RESPONSE_EXAMPLE = """
            {
                "statusCode": 404,
                "message": "Task with name 'task0' is not found!",
                "timestamp": "2024-09-26T21:41:17.0947952",
                "body": null
            }
            """;

    //================================================= Update Task =================================================//
    public static final String UPDATE_TASK_SUMMARY = "Update task";
    public static final String UPDATE_TASK_DESCRIPTION = "Update task in database.";
    public static final String UPDATE_TASK_RESPONSE_DESCRIPTION = "When task is updated.";
    public static final String UPDATE_TASK_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "Task updated!",
                "timestamp": "2024-09-26T21:48:21.223347",
                "body": {
                    "id": "a5443f59-55ea-4d6e-b287-c013f1921dca",
                    "name": "task1",
                    "description": "This is the new description for task 1"
                }
            }
            """;


    //================================================= Update Task =================================================//
    public static final String DELETE_TASK_SUMMARY = "Delete task";
    public static final String DELETE_TASK_DESCRIPTION = "Delete task in database.";
    public static final String DELETE_TASK_RESPONSE_DESCRIPTION = "When task is deleted.";
    public static final String DELETE_TASK_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "Task deleted!",
                "timestamp": "2024-09-26T21:48:33.4278012",
                "body": {
                    "id": "a5443f59-55ea-4d6e-b287-c013f1921dca",
                    "name": "task1",
                    "description": "This is the new description for task 1"
                }
            }
            """;


    private SwaggerConstant() {
    }
}
