package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "policy_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = "rule_code"))
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "rule_code", nullable = false, unique = true, length = 50)
    private String ruleCode;

    @NotBlank
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "applies_to_role", length = 100)
    private String appliesToRole;

    @Column(name = "applies_to_department", length = 100)
    private String appliesToDepartment;

    @NotNull @Min(1)
    @Column(name = "max_devices_allowed", nullable = false)
    private Integer maxDevicesAllowed;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = true;

    public PolicyRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAppliesToRole() { return appliesToRole; }
    public void setAppliesToRole(String appliesToRole) { this.appliesToRole = appliesToRole; }
    public String getAppliesToDepartment() { return appliesToDepartment; }
    public void setAppliesToDepartment(String appliesToDepartment) { this.appliesToDepartment = appliesToDepartment; }
    public Integer getMaxDevicesAllowed() { return maxDevicesAllowed; }
    public void setMaxDevicesAllowed(Integer maxDevicesAllowed) { this.maxDevicesAllowed = maxDevicesAllowed; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
