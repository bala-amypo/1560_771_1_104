package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository recordRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final EligibilityCheckService eligibilityService;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository recordRepo,
                                         EmployeeProfileRepository employeeRepo,
                                         DeviceCatalogItemRepository deviceRepo,
                                         EligibilityCheckService eligibilityService) {
        this.recordRepo = recordRepo;
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.eligibilityService = eligibilityService;
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        EmployeeProfile emp = employeeRepo.findById(record.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        if (!Boolean.TRUE.equals(emp.getActive())) {
            throw new BadRequestException("Employee inactive");
        }

        DeviceCatalogItem item = deviceRepo.findById(record.getDeviceItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Device item not found"));
        if (!Boolean.TRUE.equals(item.getActive())) {
            throw new BadRequestException("Device inactive");
        }

        IssuedDeviceRecord existing = recordRepo.findActiveByEmployeeAndDevice(record.getEmployeeId(), record.getDeviceItemId());
        if (existing != null) {
            throw new BadRequestException("Active issuance already exists for employee-device");
        }

        long activeCount = recordRepo.countActiveDevicesForEmployee(record.getEmployeeId());
        if (activeCount >= item.getMaxAllowedPerEmployee()) {
            throw new BadRequestException("maxAllowedPerEmployee exceeded");
        }

        EligibilityCheckRecord check = eligibilityService.validateEligibility(record.getEmployeeId(), record.getDeviceItemId());
        if (!Boolean.TRUE.equals(check.getIsEligible())) {
            throw new BadRequestException("Not eligible: " + check.getReason());
        }

        record.setStatus("ISSUED");
        record.setIssuedDate(LocalDate.now());
        record.setReturnedDate(null);
        return recordRepo.save(record);
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long recordId) {
        IssuedDeviceRecord rec = recordRepo.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Issuance record not found"));
        if (rec.getReturnedDate() != null) {
            throw new BadRequestException("already returned");
        }
        rec.setReturnedDate(LocalDate.now());
        rec.setStatus("RETURNED");
        return recordRepo.save(rec);
    }

    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return recordRepo.findAll().stream()
                .filter(r -> r.getEmployeeId().equals(employeeId))
                .toList();
    }
}
