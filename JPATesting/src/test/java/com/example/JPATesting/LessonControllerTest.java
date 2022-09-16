package com.example.JPATesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




import static org.assertj.core.api.Assertions.assertThat;

//@WebMvcTest()
@SpringBootTest
@AutoConfigureMockMvc
public class LessonControllerTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    LessonRepo repo;



    @Test

    @Rollback
    public void postSingleLesson() throws Exception {
       MockHttpServletRequestBuilder request = post("/lessons")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
            {
              "title": "New Phone Who Dis",
              "deliveredOn": "2022-09-15"
            }
            """);
//       request.header("Accept", "application/PrimaryView+json");
//        Lesson lesson = new Lesson();
//        lesson.setTitle("New Phone Who Dis");
//        LocalDate deliveredOn1 = LocalDate.now();
//        lesson.setDeliveredOn(deliveredOn1);
////        repo.save(lesson);
//        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
////                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

//        MockHttpServletRequestBuilder request = post("/lessons").contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(lesson));


       this.mvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.title").value("New Phone Who Dis"))
               .andExpect(jsonPath("$.deliveredOn").value("2022-09-15"));
    }
}


