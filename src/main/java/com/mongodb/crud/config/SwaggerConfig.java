package com.mongodb.crud.config;

import com.mongodb.crud.entity.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import static com.mongodb.crud.constant.HttpConstant.APPLICATION_JSON;
import static com.mongodb.crud.constant.HttpConstant.BAD_REQUEST;
import static com.mongodb.crud.constant.HttpConstant.CONFLICT;
import static com.mongodb.crud.constant.HttpConstant.CREATED;
import static com.mongodb.crud.constant.HttpConstant.NOT_FOUND;
import static com.mongodb.crud.constant.HttpConstant.OK;
import static com.mongodb.crud.constant.SwaggerConstant.CREATE_TASK_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.CREATE_TASK_REQUEST_BODY_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.CREATE_TASK_REQUEST_BODY_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.CREATE_TASK_SUMMARY;
import static com.mongodb.crud.constant.SwaggerConstant.DELETE_TASK_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.DELETE_TASK_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.DELETE_TASK_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.DELETE_TASK_SUMMARY;
import static com.mongodb.crud.constant.SwaggerConstant.DUPLICATED_TASK_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.DUPLICATED_TASK_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.GET_ALL_TASKS_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.GET_ALL_TASKS_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.GET_ALL_TASKS_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.GET_ALL_TASKS_SUMMARY;
import static com.mongodb.crud.constant.SwaggerConstant.GET_TASK_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.GET_TASK_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.GET_TASK_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.GET_TASK_SUMMARY;
import static com.mongodb.crud.constant.SwaggerConstant.INVALID_TASK_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.INVALID_TASK_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.TASK_CREATED_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.TASK_CREATED_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.TASK_NOT_FOUND_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.TASK_NOT_FOUND_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_REQUEST_BODY_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_REQUEST_BODY_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_RESPONSE_DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_RESPONSE_EXAMPLE;
import static com.mongodb.crud.constant.SwaggerConstant.UPDATE_TASK_SUMMARY;

@SuppressWarnings("checkstyle:MissingJavadocMethod")
public interface SwaggerConfig {
    @Operation(summary = CREATE_TASK_SUMMARY, description = CREATE_TASK_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = CREATE_TASK_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = Task.class),
                            examples = @ExampleObject(value = CREATE_TASK_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = CREATED,
                            description = TASK_CREATED_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = TASK_CREATED_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = BAD_REQUEST,
                            description = INVALID_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = INVALID_TASK_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = CONFLICT,
                            description = DUPLICATED_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = DUPLICATED_TASK_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    com.mongodb.crud.util.ApiResponse<Task> create(Task task);

    @Operation(summary = GET_ALL_TASKS_SUMMARY, description = GET_ALL_TASKS_DESCRIPTION,
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = GET_ALL_TASKS_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = GET_ALL_TASKS_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    com.mongodb.crud.util.ApiResponse<List<Task>> getAll();

    @Operation(summary = GET_TASK_SUMMARY, description = GET_TASK_DESCRIPTION,
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = GET_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = GET_TASK_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = NOT_FOUND,
                            description = TASK_NOT_FOUND_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = TASK_NOT_FOUND_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    com.mongodb.crud.util.ApiResponse<Task> getByName(String name);

    @Operation(summary = UPDATE_TASK_SUMMARY, description = UPDATE_TASK_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = UPDATE_TASK_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = Task.class),
                            examples = @ExampleObject(value = UPDATE_TASK_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = UPDATE_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = UPDATE_TASK_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = NOT_FOUND,
                            description = TASK_NOT_FOUND_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = TASK_NOT_FOUND_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = BAD_REQUEST,
                            description = INVALID_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = INVALID_TASK_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    com.mongodb.crud.util.ApiResponse<Task> update(String targetTaskName, Task taskUpdates);

    @Operation(summary = DELETE_TASK_SUMMARY, description = DELETE_TASK_DESCRIPTION,
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = DELETE_TASK_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = DELETE_TASK_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = NOT_FOUND,
                            description = TASK_NOT_FOUND_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON,
                                    schema = @Schema(implementation = com.mongodb.crud.util.ApiResponse.class),
                                    examples = @ExampleObject(value = TASK_NOT_FOUND_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    com.mongodb.crud.util.ApiResponse<Task> delete(String name);
}
