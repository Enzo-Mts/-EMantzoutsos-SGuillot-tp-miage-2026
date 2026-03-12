package com.acme.todolist.adapters;

import com.acme.todolist.adapters.rest_api.TodoListController;
import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.in.GetTodoItems;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoListController.class)
public class TodoListControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetTodoItems getTodoItemsQuery;

    @MockBean
    private AddTodoItem addTodoItemUseCase;

    @Test
    void getAll_doitRetourner200() throws Exception {
        when(getTodoItemsQuery.getAllTodoItems()).thenReturn(List.of());
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk());
    }
    }
