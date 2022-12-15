package com.mycompany.myapp.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mycompany.myapp.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Test class for the TodoControllerResource REST controller.
 *
 * @see TodoControllerResource
 */
@IntegrationTest
class TodoControllerResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        TodoControllerResource todoControllerResource = new TodoControllerResource();
        restMockMvc = MockMvcBuilders.standaloneSetup(todoControllerResource).build();
    }

    /**
     * Test addTodo
     */
    @Test
    void testAddTodo() throws Exception {
        restMockMvc.perform(post("/api/todo-controller/add-todo")).andExpect(status().isOk());
    }

    /**
     * Test deleteTodo
     */
    @Test
    void testDeleteTodo() throws Exception {
        restMockMvc.perform(delete("/api/todo-controller/delete-todo")).andExpect(status().isOk());
    }

    /**
     * Test editTodo
     */
    @Test
    void testEditTodo() throws Exception {
        restMockMvc.perform(put("/api/todo-controller/edit-todo")).andExpect(status().isOk());
    }

    /**
     * Test getTodos
     */
    @Test
    void testGetTodos() throws Exception {
        restMockMvc.perform(get("/api/todo-controller/get-todos")).andExpect(status().isOk());
    }

    /**
     * Test getTodo
     */
    @Test
    void testGetTodo() throws Exception {
        restMockMvc.perform(get("/api/todo-controller/get-todo")).andExpect(status().isOk());
    }
}
