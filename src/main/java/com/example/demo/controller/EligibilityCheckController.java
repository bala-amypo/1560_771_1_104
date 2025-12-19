
package com.example.demo.controller;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eligibility")
@Tag(name = "Eligibility Check Endpoints")
public class EligibilityCheckController {

private final EligibilityCheckService service;

public EligibilityCheckController(EligibilityCheckService service) {
this.service = service;
}

@PostMapping("/validate/{employeeId}/{deviceItemId}")
@Operation(summary = "Validate eligibility")
public ResponseEntity<EligibilityCheckRecord> validate(
@PathVariable Long employeeId,
@PathVariable Long deviceItemId) {
return ResponseEntity.ok(service.validateEligibility(employeeId, deviceItemId));
}

@GetMapping("/employee/{employeeId}")
@Operation(summary = "Get eligibility checks by employee")
public ResponseEntity<List<EligibilityCheckRecord>> getByEmployee(
@PathVariable Long employeeId) {
return ResponseEntity.ok(service.getChecksByEmployee(employeeId));
}
}