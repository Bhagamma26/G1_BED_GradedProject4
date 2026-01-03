package com.example.employeesecurityproject.controller;

import com.example.employeesecurityproject.entity.Role;
import com.example.employeesecurityproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
