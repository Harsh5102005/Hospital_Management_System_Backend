package com.hospital.system.Controller;

import com.hospital.system.dto.InsuranceRequestDto;
import com.hospital.system.dto.InsuranceResponseDto;
import com.hospital.system.dto.PatientResponseDto;
import com.hospital.system.service.InsuranceServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceServiceDto insuranceService;

    @GetMapping
    public List<InsuranceResponseDto> getAllInsurance() {
        return insuranceService.getAllInsurance();
    }

    @GetMapping("/{id}")
    public InsuranceResponseDto getInsuranceById(@PathVariable Long id) {
        return insuranceService.getInsuranceById(id);
    }

    @PostMapping
    public ResponseEntity<InsuranceResponseDto> createInsurance(@RequestBody InsuranceRequestDto insuranceRequestDto) {
        InsuranceResponseDto response = insuranceService.createInsurance(insuranceRequestDto);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceResponseDto> updateInsurance(@PathVariable Long id, @RequestBody InsuranceRequestDto insuranceRequestDto) {
        InsuranceResponseDto response = insuranceService.updateInsurance(id, insuranceRequestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/assign/{insuranceId}/patient/{patientId}")
    public ResponseEntity<PatientResponseDto> assignInsuranceToPatient(
            @PathVariable Long insuranceId,
            @PathVariable Long patientId) {
        PatientResponseDto response = insuranceService.assignInsurance(insuranceId, patientId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/disassociate/{patientId}")
    public ResponseEntity<PatientResponseDto> disassociateInsuranceFromPatient(
            @PathVariable Long patientId) {
        PatientResponseDto response = insuranceService.disassociateInsurance(patientId);
        return ResponseEntity.ok(response);
    }
}

