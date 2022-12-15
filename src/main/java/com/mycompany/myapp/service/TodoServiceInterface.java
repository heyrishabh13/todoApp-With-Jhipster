package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoServiceInterface {
    // Save operation
    Todo saveTodo(Todo todo);

    // Read operation
    List<Todo> fetchTodoList();

    // Read operation
    Todo fetchTodo(Long todoId);

    // Update operation
    Todo updateTodo(Todo todo, Long todoId);

    // Delete operation
    void deleteTodoById(Long todoId);
}
