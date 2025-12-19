package com.example.demo.model;

import java.time.LocalDate;

public class EligibilityCheckRecord {
    private long id;
    private long employeeID;
    private long deviceItemId;
    private Boolean isEligible;
    private String reason;
    private LocalDate checkedAt;

    public EligibilityCheckRecord(){
        
    }

    public EligibilityCheckRecord(long employeeID, long deviceItemId, Boolean isEligible, String reason,
            LocalDate checkedAt) {
        this.employeeID = employeeID;
        this.deviceItemId = deviceItemId;
        this.isEligible = isEligible;
        this.reason = reason;
        this.checkedAt = checkedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getDeviceItemId() {
        return deviceItemId;
    }

    public void setDeviceItemId(long deviceItemId) {
        this.deviceItemId = deviceItemId;
    }

    public Boolean getIsEligible() {
        return isEligible;
    }

    public void setIsEligible(Boolean isEligible) {
        this.isEligible = isEligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDate checkedAt) {
        this.checkedAt = checkedAt;
    }
    
}
