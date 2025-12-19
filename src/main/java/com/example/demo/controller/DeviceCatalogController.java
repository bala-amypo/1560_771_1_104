package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> create(@Valid @RequestBody DeviceCatalogItem item) {
        return ResponseEntity.ok(service.createItem(item));
    }

    @PutMapping("/{id}/active")
    public ResponseEntity<DeviceCatalogItem> updateActive(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateActiveStatus(id, active));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }
}
