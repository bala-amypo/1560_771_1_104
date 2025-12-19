package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issued_device_record")
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "device_item_id", nullable = false)
    private Long deviceItemId;

    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @Column(name = "status", nullable = false)
    private String status; // "ISSUED" or "RETURNED"

    public IssuedDeviceRecord() {
    }

    public IssuedDeviceRecord(Long employeeId, Long deviceItemId, LocalDate issuedDate, LocalDate returnedDate) {
        this.employeeId = employeeId;
        this.deviceItemId = deviceItemId;
        this.issuedDate = issuedDate;
        this.returnedDate = returnedDate;
        this.status = (returnedDate == null) ? "ISSUED" : "RETURNED";
    }

    @PrePersist
    @PreUpdate
    private void updateStatus() {
        this.status = (this.returnedDate == null) ? "ISSUED" : "RETURNED";
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

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
        this.status = (returnedDate == null) ? "ISSUED" : "RETURNED";
    }

    public String getStatus() {
        return status;
    }
}
