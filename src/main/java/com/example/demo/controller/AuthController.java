package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Endpoints")
public class AuthController {

private final AuthService authService;

public AuthController(AuthService authService) {
this.authService = authService;
}

@PostMapping("/register")
@Operation(summary = "Register new user")
public ResponseEntity<UserAccount> register(@RequestBody UserAccount user) {
return ResponseEntity.ok(authService.register(user));
}

@PostMapping("/login")
@Operation(summary = "User login")
public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
return ResponseEntity.ok(authService.login(request));
}
}




DeviceCatalogController

package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Catalog Endpoints")
public class DeviceCatalogController {

private final DeviceCatalogService service;

public DeviceCatalogController(DeviceCatalogService service) {
this.service = service;
}

@PostMapping
@Operation(summary = "Create device")
public ResponseEntity<DeviceCatalogItem> create(@RequestBody DeviceCatalogItem item) {
return ResponseEntity.ok(service.createItem(item));
}

@GetMapping
@Operation(summary = "Get all devices")
public ResponseEntity<List<DeviceCatalogItem>> getAll() {
return ResponseEntity.ok(service.getAllItems());
}

@PutMapping("/{id}/active")
@Operation(summary = "Update device active status")
public ResponseEntity<DeviceCatalogItem> updateStatus(
@PathVariable Long id,
@RequestParam boolean active) {
return ResponseEntity.ok(service.updateActiveStatus(id, active));
}
}

IssuedDeviceRecordController

package com.example.demo.controller;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issued-devices")
@Tag(name = "Issued Device Records Endpoints")
public class IssuedDeviceRecordController {

private final IssuedDeviceRecordService service;

public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
this.service = service;
}

@PostMapping
@Operation(summary = "Issue device")
public ResponseEntity<IssuedDeviceRecord> issue(@RequestBody IssuedDeviceRecord record) {
return ResponseEntity.ok(service.issueDevice(record));
}

@PutMapping("/{id}/return")
@Operation(summary = "Return device")
public ResponseEntity<IssuedDeviceRecord> returnDevice(@PathVariable Long id) {
return ResponseEntity.ok(service.returnDevice(id));
}

@GetMapping("/employee/{employeeId}")
@Operation(summary = "Get devices by employee")
public ResponseEntity<List<IssuedDeviceRecord>> getByEmployee(@PathVariable Long employeeId) {
return ResponseEntity.ok(service.getIssuedDevicesByEmployee(employeeId));
}
}

PolicyRuleController
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

EligibilityCheckController
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