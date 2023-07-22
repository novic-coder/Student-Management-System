/*package com.ravi.springapp.StudentManagementSystem.junitMokito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.springapp.StudentManagementSystem.studentService.Students;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitMokitaApplicationTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    ObjectMapper objectMapper = new ObjectMapper();

    // Initializing mock MVC
    @Before
    private void setUp(){
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public  void addStudentTest() throws Exception {
        Students students = new Students();
        students.setStudentName("Suman");
        students.setPhoneNumber("7004290989");
        students.setDateOfBirth(LocalDate.now().minusYears(34));
        String jsonRequest = objectMapper.writeValueAsString(students);
        MvcResult result = mockMvc. perform(post("/jpa/students").content(jsonRequest).content(MediaType.APPLICATION_PROBLEM_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();

    }
}*/
