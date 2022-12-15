package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Todo;
import com.mycompany.myapp.repository.TodoRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TodoService {
    // Save operation
    Todo saveTodo(Todo todo);

    // Read operation
    List<Todo> fetchTodoList();

    // Read operation
    Optional<Todo> fetchTodo(Long todoId);

    // Update operation
    Todo updateTodo(Todo todo, Long todoId);

    // Delete operation
    void deleteTodoById(Long todoId);
}
