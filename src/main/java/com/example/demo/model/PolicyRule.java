package com.example.demo.Model;

public class PolicyRule {
    private long id;
    private String ruleCode;
    private String description;
    private String appliesToDepartment;
    private int maxDevicesAllowed;
    private boolean active;

    public  PolicyRule(){
        
    }

    public PolicyRule(String ruleCode, String description, String appliesToDepartment, int maxDevicesAllowed,
            boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.appliesToDepartment = appliesToDepartment;
        this.maxDevicesAllowed = maxDevicesAllowed;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAppliesToDepartment() {
        return appliesToDepartment;
    }

    public void setAppliesToDepartment(String appliesToDepartment) {
        this.appliesToDepartment = appliesToDepartment;
    }

    public int getMaxDevicesAllowed() {
        return maxDevicesAllowed;
    }

    public void setMaxDevicesAllowed(int maxDevicesAllowed) {
        this.maxDevicesAllowed = maxDevicesAllowed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
