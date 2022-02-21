package com.tdd.springtest.controller;

import com.tdd.springtest.models.Employee;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRESTController {

    @GetMapping
    public List<Employee> getAllEmployees() {
        return null;
    }

    @GetMapping("/{id}")
    public RequestEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        return null;
    }

}
