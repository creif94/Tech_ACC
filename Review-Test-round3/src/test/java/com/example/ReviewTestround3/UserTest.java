package com.example.ReviewTestround3;


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

public class UserTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepo repo;

    User newUser1;
    User newUser2;

@BeforeEach
    public void init() {
    //Setting up the New Users, that gets created before each test
        newUser1 = new User();
        newUser2 = new User();
        newUser1.setEmail("john@example.com");
        newUser1.setPassword("abc");
        System.out.println("newUser1 was created");
        newUser2.setEmail("jane@example.com");
        newUser2.setPassword("abcd");
        System.out.println("newUser2 was created");
    }

    //Testing the Post and the Get
    @Test
    @Transactional
    @Rollback
    public void testingPostUsers() throws Exception {

        MockHttpServletRequestBuilder request = post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                            {
                              
                              "email": "john@example.com",
                              "password": "abc"
                            }
                           
                        """);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    @Transactional
    @Rollback
    public void testingGettingOneUser() throws Exception {

        repo.save(newUser1); //id 2
        repo.save(newUser2); // id 3
        Long userID = newUser1.getId();
        this.mvc.perform(get("/users/" + userID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userID))
                .andExpect(jsonPath("$.email").value("john@example.com"));

    }

    @Test
    @Transactional
    @Rollback
    public void testingDeleteUser() throws Exception {
     repo.save(newUser1);
     repo.save(newUser2);
     Long userID = newUser1.getId();
     this.mvc.perform(delete("/users/"+ userID ))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.count").value(1));
    }
    @Test
    @Transactional
    @Rollback
    public void testingPatchUser() throws Exception {
        repo.save(newUser1);
        repo.save(newUser2);
        Long userID = newUser1.getId();
        this.mvc.perform(patch("/users/"+userID)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "email": "angelica@example.com",
                          "password": "1234"
                        }
                        
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userID))
                .andExpect(jsonPath("$.email").value("angelica@example.com"));
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testingGettingAllUsers() throws Exception{
        repo.save(newUser1);
        repo.save(newUser2);
        Long userID = newUser1.getId();
        this.mvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[1].email").value("jane@example.com"));
        }
 }

 /*
 *   [
    {
      "id": 1,
      "email": "john@example.com"
    },
    {
      "id": 2,
      "email": "eliza@example.com"
    }
  ]
 * */