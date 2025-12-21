package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuanceRepo;
    private final PolicyRuleRepository ruleRepo;
    private final EligibilityCheckRecordRepository checkRepo;

    public EligibilityCheckServiceImpl(EmployeeProfileRepository employeeRepo,
                                       DeviceCatalogItemRepository deviceRepo,
                                       IssuedDeviceRecordRepository issuanceRepo,
                                       PolicyRuleRepository ruleRepo,
                                       EligibilityCheckRecordRepository checkRepo) {
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.issuanceRepo = issuanceRepo;
        this.ruleRepo = ruleRepo;
        this.checkRepo = checkRepo;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EmployeeProfile emp = employeeRepo.findById(employeeId).orElse(null);
        DeviceCatalogItem item = deviceRepo.findById(deviceItemId).orElse(null);

        boolean eligible = true;
        String reason = "Eligible";

        if (emp == null || !Boolean.TRUE.equals(emp.getActive())) {
            eligible = false; reason = "Employee inactive or not found";
        } else if (item == null || !Boolean.TRUE.equals(item.getActive())) {
            eligible = false; reason = "Device inactive or not found";
        } else {
            long activeCount = issuanceRepo.countActiveDevicesForEmployee(employeeId);
            if (activeCount >= item.getMaxAllowedPerEmployee()) {
                eligible = false; reason = "maxAllowedPerEmployee exceeded";
            }
            List<PolicyRule> rules = ruleRepo.findByActiveTrue();
            for (PolicyRule rule : rules) {
                boolean roleMatch = rule.getAppliesToRole() == null || rule.getAppliesToRole().equalsIgnoreCase(emp.getJobRole());
                boolean deptMatch = rule.getAppliesToDepartment() == null || rule.getAppliesToDepartment().equalsIgnoreCase(emp.getDepartment());
                if (roleMatch && deptMatch && activeCount >= rule.getMaxDevicesAllowed()) {
                    eligible = false; reason = "Policy rule limit reached: " + rule.getRuleCode();
                    break;
                }
            }
        }

        EligibilityCheckRecord check = new EligibilityCheckRecord();
        check.setEmployeeId(employeeId);
        check.setDeviceItemId(deviceItemId);
        check.setIsEligible(eligible);
        check.setReason(reason);
        return checkRepo.save(check);
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return checkRepo.findByEmployeeId(employeeId);
    }
}
