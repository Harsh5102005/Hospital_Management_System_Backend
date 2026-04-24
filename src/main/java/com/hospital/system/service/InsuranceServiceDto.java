package com.hospital.system.service;

import com.hospital.system.Entity.Insurance;
import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.InsuranceRepository;
import com.hospital.system.Repository.PatientRepository;
import com.hospital.system.dto.InsuranceRequestDto;
import com.hospital.system.dto.InsuranceResponseDto;
import com.hospital.system.dto.PatientResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceDto {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public List<InsuranceResponseDto> getAllInsurance() {
        List<Insurance> insurances = insuranceRepository.findAll();
        return insurances.stream()
                .map(this::mapToDto)
                .toList();
    }

    public InsuranceResponseDto getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));
        return mapToDto(insurance);
    }

    public InsuranceResponseDto createInsurance(InsuranceRequestDto insuranceRequestDto) {
        Insurance insurance = Insurance.builder()
                .policyNo(insuranceRequestDto.getPolicyNo())
                .provider(insuranceRequestDto.getProvider())
                .endDate(insuranceRequestDto.getEndDate())
                .build();
        Insurance savedInsurance = insuranceRepository.save(insurance);
        return mapToDto(savedInsurance);
    }

    public InsuranceResponseDto updateInsurance(Long id, InsuranceRequestDto insuranceRequestDto) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + id));
        insurance.setPolicyNo(insuranceRequestDto.getPolicyNo());
        insurance.setProvider(insuranceRequestDto.getProvider());
        insurance.setEndDate(insuranceRequestDto.getEndDate());
        Insurance updatedInsurance = insuranceRepository.save(insurance);
        return mapToDto(updatedInsurance);
    }

    public void deleteInsurance(Long id) {
        if (!insuranceRepository.existsById(id)) {
            throw new RuntimeException("Insurance not found with id: " + id);
        }
        insuranceRepository.deleteById(id);
    }

    @Transactional
    public PatientResponseDto assignInsurance(Long insuranceId, Long patientId) {
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new RuntimeException("Insurance not found with id: " + insuranceId));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        // Only set on the owning side (Patient) - this automatically updates both sides
        patient.setInsurance(insurance);
        patientRepository.save(patient);

        return mapPatientToDto(patient);
    }

    @Transactional
    public PatientResponseDto disassociateInsurance(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
        patient.setInsurance(null);
        patientRepository.save(patient);

        return mapPatientToDto(patient);
    }

    private InsuranceResponseDto mapToDto(Insurance insurance) {
        InsuranceResponseDto dto = new InsuranceResponseDto();
        dto.setId(insurance.getId());
        dto.setPolicyNo(insurance.getPolicyNo());
        dto.setProvider(insurance.getProvider());
        dto.setEndDate(insurance.getEndDate());
        dto.setCreateDate(insurance.getCreateDate());
        return dto;
    }

    private PatientResponseDto mapPatientToDto(Patient patient) {
        PatientResponseDto dto = new PatientResponseDto();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setGender(patient.getGender());
        dto.setEmail(patient.getEmail());
        dto.setBirthdate(patient.getBirthdate());
        return dto;
    }
}

