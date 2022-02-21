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
    public RequestEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
