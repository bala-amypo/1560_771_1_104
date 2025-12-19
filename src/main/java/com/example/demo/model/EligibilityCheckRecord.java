package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eligibility_check_records")
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotNull
    @Column(name = "device_item_id", nullable = false)
    private Long deviceItemId;

    @NotNull
    @Column(name = "is_eligible", nullable = false)
    private Boolean isEligible;

    @NotBlank
    @Column(name = "reason", nullable = false, length = 255)
    private String reason;

    @Column(name = "checked_at", nullable = false)
    private LocalDateTime checkedAt;

    public EligibilityCheckRecord() {}

    @PrePersist
    public void onCheck() {
        this.checkedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public Long getDeviceItemId() { return deviceItemId; }
    public void setDeviceItemId(Long deviceItemId) { this.deviceItemId = deviceItemId; }
    public Boolean getIsEligible() { return isEligible; }
    public void setIsEligible(Boolean isEligible) { this.isEligible = isEligible; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}
