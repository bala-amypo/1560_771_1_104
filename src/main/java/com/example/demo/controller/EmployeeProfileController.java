
package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Profile Endpoints")
public class EmployeeProfileController {

private final EmployeeProfileService service;

public EmployeeProfileController(EmployeeProfileService service) {
this.service = service;
}

@PostMapping
@Operation(summary = "Create employee")
public ResponseEntity<EmployeeProfile> create(@RequestBody EmployeeProfile employee) {
return ResponseEntity.ok(service.createEmployee(employee));
}

@GetMapping
@Operation(summary = "Get all employees")
public ResponseEntity<List<EmployeeProfile>> getAll() {
return ResponseEntity.ok(service.getAllEmployees());
}

@GetMapping("/{id}")
@Operation(summary = "Get employee by id")
public ResponseEntity<EmployeeProfile> getById(@PathVariable Long id) {
return ResponseEntity.ok(service.getEmployeeById(id));
}

@PutMapping("/{id}/status")
@Operation(summary = "Update employee status")
public ResponseEntity<EmployeeProfile> updateStatus(
@PathVariable Long id,
@RequestParam boolean active) {
return ResponseEntity.ok(service.updateEmployeeStatus(id, active));
}
}