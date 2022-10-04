package com.example.ReviewProject3;

import com.example.ReviewProject3.toDo;
import com.example.ReviewProject3.toDoRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ControllerClassTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    toDoRepo repo;

    toDo newTask1;
    toDo newTask2;
    toDo newTask3;

    @BeforeEach
    public void setup() {
        newTask1 = new toDo();
        newTask2 = new toDo();
        newTask3 = new toDo();
        newTask1.setDueDate("2022-01-01");
        newTask2.setDueDate("2022-02-01");
        newTask3.setDueDate("2022-03-01");
        newTask1.setPriority("High");
        newTask2.setPriority("Medium");
        newTask3.setPriority("Low");
        newTask1.setDescription("Task#1");
        newTask2.setDescription("Task#2");
        newTask3.setDescription("Task#3");
    }

    @Test
    @Transactional
    @Rollback
    public void newTask() throws Exception {
        MockHttpServletRequestBuilder request = post("/toDo")
               .contentType(MediaType.APPLICATION_JSON)
               .content("""
                {
                    "dueDate": "2022-01-01",
                    "priority": "High",
                    "description": "Task#1"
                }
                """);
        this.mvc.perform(request)
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$").isEmpty())
                .andExpect(jsonPath("$.dueDate").value("2022-01-01"))
                .andExpect(jsonPath("$.priority").value("High"));

    }
    @Test
    @Transactional
    @Rollback
    public void gettingAlltoDo() throws Exception {
        this.repo.save(newTask1);
        this.repo.save(newTask2);
        this.repo.save(newTask3);
    MockHttpServletRequestBuilder request = get("/toDo")
            .contentType(MediaType.APPLICATION_JSON);
    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].dueDate").value("2022-01-01"))
            .andExpect(jsonPath("$[1].description").value("Task#2"));

    }
}
