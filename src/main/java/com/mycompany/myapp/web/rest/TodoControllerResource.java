package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Todo;
import com.mycompany.myapp.service.TodoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TodoControllerResource controller
 */

@RestController
@RequestMapping("/api/todo-controller")
public class TodoControllerResource {

    private final Logger log = LoggerFactory.getLogger(TodoControllerResource.class);

    // Annotation
    @Autowired
    private TodoService todoService;

    // Read operation
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-todos")
    public List<Todo> fetchTodoList() {
        return todoService.fetchTodoList();
    }

    // Read operation
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-todo/{id}")
    public Optional<Todo> fetchTodo(@PathVariable("id") Long todoId) {
        return todoService.fetchTodo(todoId);
    }

    // Post operation
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/post-todo")
    public Todo postTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    // Update operation
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/edit-todo/{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable("id") Long todoId) {
        return todoService.updateTodo(todo, todoId);
    }

    // Delete operation
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete-todo/{id}")
    public String deleteTodoById(@PathVariable("id") Long todoId) {
        todoService.deleteTodoById(todoId);
        return "Deleted Successfully";
    }
}
