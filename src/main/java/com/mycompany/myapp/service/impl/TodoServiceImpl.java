package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Todo;
import com.mycompany.myapp.repository.TodoRepository;
import com.mycompany.myapp.service.TodoService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);

    // Annotation
    @Autowired
    private TodoRepository todoRepository;

    // Save operation
    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Read operation
    @Override
    public List<Todo> fetchTodoList() {
        return (List<Todo>) todoRepository.findAll();
    }

    // Update operation
    @Override
    public Todo updateTodo(Todo todo, Long todoId) {
        Todo todoDB = todoRepository.findById(todoId).get();

        if (Objects.nonNull(todo.getName()) && !"".equalsIgnoreCase(todo.getName())) {
            todoDB.setName(todo.getName());
        }

        if (Objects.nonNull(todo.getDescription()) && !"".equalsIgnoreCase(todo.getDescription())) {
            todoDB.setDescription(todo.getDescription());
        }

        return todoRepository.save(todoDB);
    }

    // Delete operation
    @Override
    public void deleteTodoById(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public Optional<Todo> fetchTodo(Long todoId) {
        // TODO Auto-generated method stub
        Optional<Todo> todo = todoRepository.findById(todoId);

        return todo;
    }
}
