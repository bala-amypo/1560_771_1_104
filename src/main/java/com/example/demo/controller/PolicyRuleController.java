
package com.example.demo.controller;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-rules")
@Tag(name = "Policy Rules Endpoints")
public class PolicyRuleController {

private final PolicyRuleService service;

public PolicyRuleController(PolicyRuleService service) {
this.service = service;
}

@PostMapping
@Operation(summary = "Create policy rule")
public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
return ResponseEntity.ok(service.createRule(rule));
}

@GetMapping
@Operation(summary = "Get all rules")
public ResponseEntity<List<PolicyRule>> getAll() {
return ResponseEntity.ok(service.getAllRules());
}

@GetMapping("/active")
@Operation(summary = "Get active rules")
public ResponseEntity<List<PolicyRule>> getActive() {
return ResponseEntity.ok(service.getActiveRules());
}
}
