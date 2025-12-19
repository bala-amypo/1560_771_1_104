package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "device_catalog_items",
       uniqueConstraints = @UniqueConstraint(columnNames = "device_code"))
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "device_code", nullable = false, unique = true, length = 50)
    private String deviceCode;

    @NotBlank
    @Column(name = "device_type", nullable = false, length = 50)
    private String deviceType;

    @NotBlank
    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @NotNull @Min(1)
    @Column(name = "max_allowed_per_employee", nullable = false)
    private Integer maxAllowedPerEmployee;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = true;

    public DeviceCatalogItem() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceCode() { return deviceCode; }
    public void setDeviceCode(String deviceCode) { this.deviceCode = deviceCode; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getMaxAllowedPerEmployee() { return maxAllowedPerEmployee; }
    public void setMaxAllowedPerEmployee(Integer maxAllowedPerEmployee) { this.maxAllowedPerEmployee = maxAllowedPerEmployee; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
