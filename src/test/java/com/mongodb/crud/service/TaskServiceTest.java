package com.mongodb.crud.service;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.exception.DuplicateResourceException;
import com.mongodb.crud.exception.NullResourceException;
import com.mongodb.crud.exception.ResourceNotFoundException;
import com.mongodb.crud.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Task Service")
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("checkstyle:MethodName")
class TaskServiceTest {

    private final String expectedName = "name";
    private final String expectedDescription = "description";
    private Task task;

    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void init() {
        task = new Task(expectedName, expectedDescription);
    }

    @Nested
    @DisplayName("Create Task")
    class CreateTaskTest {
        @Test
        @DisplayName("Create task when it is valid")
        void Should_CreateTask_When_TaskIsValid() {
            when(taskRepository.findByName(anyString())).thenReturn(null);
            when(taskRepository.save(any(Task.class))).thenReturn(task);

            taskService.create(task);

            assertAll("Assert it is the same task",
                    () -> assertNotNull(task, "Task is null"),
                    () -> assertEquals(expectedName, task.getName(), "Task name mismatch"),
                    () -> assertEquals(expectedDescription, task.getDescription(), "Task description mismatch")
            );

            verify(taskRepository, times(1)).findByName(anyString());
            verify(taskRepository, times(1)).save(any(Task.class));
        }

        @Test
        @DisplayName("Throw exception when task is null")
        void Should_ThrowException_When_TaskIsNull() {
            assertThrows(NullResourceException.class, () -> taskService.create(null));

            verify(taskRepository, times(0)).findByName(anyString());
            verify(taskRepository, times(0)).save(any(Task.class));
        }

        @Test
        @DisplayName("Throw exception when name is null")
        void Should_ThrowException_When_NameIsNull() {
            Task taskWithNullName = new Task(null, expectedDescription);

            assertThrows(IllegalArgumentException.class, () -> taskService.create(taskWithNullName));

            verify(taskRepository, times(0)).findByName(anyString());
            verify(taskRepository, times(0)).save(any(Task.class));
        }

        @Test
        @DisplayName("Throw exception when name is empty")
        void Should_ThrowException_When_NameIsEmpty() {
            Task taskWithEmptyName = new Task("    ", expectedDescription);

            assertThrows(IllegalArgumentException.class, () -> taskService.create(taskWithEmptyName));

            verify(taskRepository, times(0)).findByName(anyString());
            verify(taskRepository, times(0)).save(any(Task.class));
        }

        @Test
        @DisplayName("Throw exception when task already exists")
        void Should_ThrowException_When_TaskAlreadyExists() {
            when(taskRepository.findByName(anyString())).thenReturn(task);

            assertThrows(DuplicateResourceException.class, () -> taskService.create(task));

            verify(taskRepository, times(1)).findByName(anyString());
            verify(taskRepository, times(0)).save(any(Task.class));
        }
    }

    @Nested
    @DisplayName("Get Task by Name")
    class GetTaskByNameTest {
        @Test
        @DisplayName("Get task by name when it exists")
        void Should_GetTask_When_TaskExists() {
            when(taskRepository.findByName(anyString())).thenReturn(task);

            taskService.getByName(expectedName);

            assertAll("Assert it is the same task",
                    () -> assertNotNull(task, "Task is null"),
                    () -> assertEquals(expectedName, task.getName(), "Task name mismatch"),
                    () -> assertEquals(expectedDescription, task.getDescription(), "Task description mismatch")
            );

            verify(taskRepository, times(1)).findByName(anyString());
        }

        @Test
        @DisplayName("Throw exception when task is not found")
        void Should_ThrowException_When_TaskIsNotFound() {
            when(taskRepository.findByName(anyString())).thenReturn(null);

            assertThrows(ResourceNotFoundException.class, () -> taskService.getByName(expectedName));

            verify(taskRepository, times(1)).findByName(anyString());
        }
    }

    @Test
    @DisplayName("Get all tasks when they exist")
    void Should_GetAllTasks_When_TasksExist() {
        Task expectedTask1 = new Task(expectedName, expectedDescription);
        Task expectedTask2 = new Task(expectedName, expectedDescription);
        List<Task> tasks = List.of(expectedTask1, expectedTask2);
        when(taskRepository.findAll()).thenReturn(tasks);

        taskService.getAll();

        assertAll("Assert they are exactly the same tasks",
                () -> assertNotNull(tasks, "Tasks is null"),
                () -> assertEquals(expectedTask1, tasks.getFirst(), "First task mismatch"),
                () -> assertEquals(expectedTask2, tasks.getLast(), "Last task mismatch")
        );

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Update task when it exists")
    void Should_UpdateTask_When_TaskExists() {
        Task taskUpdates = new Task("new name", "new description");
        when(taskRepository.findByName(anyString())).thenReturn(task);
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        taskService.update(task.getName(), taskUpdates);

        assertAll("Assert that task is updated",
                () -> assertNotNull(task, "Task is null"),
                () -> assertEquals(taskUpdates.getName(), task.getName(), "Task name mismatch"),
                () -> assertEquals(taskUpdates.getDescription(), task.getDescription(), "Task description mismatch")
        );

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Delete task when it exists")
    void Should_DeleteTask_When_TaskExists() {
        when(taskRepository.findByName(anyString())).thenReturn(task);

        taskService.delete(task.getName());

        verify(taskRepository, times(1)).findByName(anyString());
        verify(taskRepository, times(1)).deleteById(task.getId());
    }
}
