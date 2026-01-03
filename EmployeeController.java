package com.example.employeesecurityproject.controller;
import com.example.employeesecurityproject.entity.Employee;
import com.example.employeesecurityproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @PostMapping
    public Employee add(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping
    public Employee update(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/search/{name}")
    public List<Employee> search(@PathVariable String name) {
        return repo.findByFirstName(name);
    }

    @GetMapping("/sort")
    public List<Employee> sort(@RequestParam String order) {
        return order.equalsIgnoreCase("asc") ?
                repo.findAll(Sort.by("firstName").ascending()) :
                repo.findAll(Sort.by("firstName").descending());
    }
}
