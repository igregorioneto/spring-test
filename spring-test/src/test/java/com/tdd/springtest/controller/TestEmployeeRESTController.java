package com.tdd.springtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.springtest.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRESTController.class)
public class TestEmployeeRESTController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllEmployeesAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].id").isNotEmpty());
    }

    @Test
    public void getAllEmployeeByIdAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/employees/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void createEmployeeAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .post("/employees")
                .content(asJsonString(new Employee(null, "firstName4", "lastName4", "email4@mail.com")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void updateEmployeeAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/employees/{id}", 2L)
                .content(asJsonString(new Employee(2L, "firstName2", "lastName2", "email2@mail.com")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstName2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastName2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
