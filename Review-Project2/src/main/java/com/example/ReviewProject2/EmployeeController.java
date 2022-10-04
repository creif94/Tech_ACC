package com.example.ReviewProject2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeRepo repo;
    public EmployeeController(EmployeeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return this.repo.findAll();
    }

    @PostMapping("")
    public Employee postEmployee(@RequestBody Employee employee) {
        return this.repo.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        this.repo.deleteById(id);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return this.repo.findById(id).get();
    }
    @PostMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        

    }



}
