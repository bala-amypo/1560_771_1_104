package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eligibility_check_record")
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "device_item_id", nullable = false)
    private Long deviceItemId;

    @Column(name = "is_eligible", nullable = false)
    private Boolean isEligible;

    @Column(name = "reason")
    private String reason;

    @Column(name = "checked_at", nullable = false)
    private LocalDateTime checkedAt;

    public EligibilityCheckRecord() {
    }

    public EligibilityCheckRecord(Long employeeId, Long deviceItemId, Boolean isEligible, String reason) {
        this.employeeId = employeeId;
        this.deviceItemId = deviceItemId;
        this.isEligible = isEligible;
        this.reason = reason;
    }

    @PrePersist
    protected void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDeviceItemId() {
        return deviceItemId;
    }

    public void setDeviceItemId(Long deviceItemId) {
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

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
