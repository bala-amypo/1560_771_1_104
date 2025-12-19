package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "policy_rule",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "rule_code") // ruleCode must be unique
    }
)
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @Column(name = "description")
    private String description;

    @Column(name = "applies_to_role")
    private String appliesToRole; // optional field if needed

    @Column(name = "applies_to_department")
    private String appliesToDepartment;

    @Column(name = "max_devices_allowed", nullable = false)
    private Integer maxDevicesAllowed;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public PolicyRule() {
    }

    public PolicyRule(String ruleCode, String description, String appliesToRole,
                      String appliesToDepartment, Integer maxDevicesAllowed, Boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.appliesToRole = appliesToRole;
        this.appliesToDepartment = appliesToDepartment;
        this.maxDevicesAllowed = maxDevicesAllowed;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppliesToRole() {
        return appliesToRole;
    }

    public void setAppliesToRole(String appliesToRole) {
        this.appliesToRole = appliesToRole;
    }

    public String getAppliesToDepartment() {
        return appliesToDepartment;
    }

    public void setAppliesToDepartment(String appliesToDepartment) {
        this.appliesToDepartment = appliesToDepartment;
    }

    public Integer getMaxDevicesAllowed() {
        return maxDevicesAllowed;
    }

    public void setMaxDevicesAllowed(Integer maxDevicesAllowed) {
        this.maxDevicesAllowed = maxDevicesAllowed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
