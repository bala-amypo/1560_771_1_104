
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