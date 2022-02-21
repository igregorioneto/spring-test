package com.tdd.springtest.controller;

import com.tdd.springtest.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employee, HttpStatus.CREATED);
    }

}
