package com.example.springTest;

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

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    donutRepo repo;

    donut newDonut1;
    donut newDonut2;


    @BeforeEach
    public void setup() {
        newDonut1 = new donut();
        newDonut1.setName("new donut 1");
        newDonut1.setTopping("sugar");
        newDonut1.setExperation("1023-02-09");
        newDonut2 = new donut();
        newDonut2.setName("new donut 2");
        newDonut2.setTopping("meat");
        newDonut2.setExperation("2022-01-01");
    }

    //Testing the Post Single
    @Test
    @Transactional
    @Rollback
    public void testPost() throws Exception {
        MockHttpServletRequestBuilder request = post("/donut")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
             {
                    "name": "Strawberry",
                    "topping": "sugar",
                    "experation": "2022-01-02"
             }
                           
                        """);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Strawberry"))
                .andExpect(jsonPath("$.topping").value("sugar"))
                .andExpect(jsonPath("$.experation").value("2022-01-02"));
    }


    @Test
    @Transactional
    @Rollback
    public void testPostList() throws Exception {
        MockHttpServletRequestBuilder request = post("/donut/batch")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
          [
              {
                  "name": "Strawberry",
                  "topping": "sugar",
                  "experation": "2022-01-02"
              },
              {
                  "name": "blueberry",
                  "topping": "cream",
                  "experation": "2022-02-02"
              }
          ]
                           
                        """);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Strawberry"))
                .andExpect(jsonPath("$[0].topping").value("sugar"))
                .andExpect(jsonPath("$[0].experation").value("2022-01-02"));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetSingle() throws Exception {
        this.repo.save(newDonut1);
        this.repo.save(newDonut2);
        Long ID = newDonut1.getId();
        this.mvc.perform(get("/donut/" + ID))
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.topping").value("sugar"))
                .andExpect(jsonPath("$.name").value("new donut 1"));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetList() throws Exception {
        this.repo.save(newDonut1);
        this.repo.save(newDonut2);
        Long ID = newDonut1.getId();
        this.mvc.perform(get("/donut"))
                .andExpect(jsonPath("$[0].name").value("new donut 1"))
                .andExpect(jsonPath("$[0].topping").value("sugar"))
                .andExpect(jsonPath("$[1].name").value("new donut 2"))
                .andExpect(jsonPath("$[1].topping").value("meat"));
    }

    @Test
    @Transactional
    @Rollback
    public void testingPatchDonut() throws Exception {
        repo.save(newDonut1);
        repo.save(newDonut2);
        Long ID = newDonut1.getId();
        this.mvc.perform(patch("/donut/"+ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "topping": "this should have changed"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.topping").value("this should have changed"));

    }
    @Test
    @Transactional
    @Rollback
    public void testingDeleteDonut() throws Exception {
        repo.save(newDonut1);
        repo.save(newDonut2);
        Long ID = newDonut1.getId();
        this.mvc.perform(delete("/donut/"+ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.context").value("Successfully Deleted"));
    }
}



