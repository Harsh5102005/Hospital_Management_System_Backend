package com.hospital.system.service;

import com.hospital.system.Entity.Insurance;
import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.InsuranceRepository;
import com.hospital.system.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    public List<Insurance> findAll(){
        return insuranceRepository.findAll();
    }
    public Insurance findById(Long id){
        return insuranceRepository.findById(id).orElseThrow();
    }
    @Transactional
    public Patient assignInsurance(Insurance insurance, Long patient_id){
        Patient patient=patientRepository.findById(patient_id).orElseThrow(()-> new RuntimeException("patient not found"));
        insurance.setPatient(patient);
        patient.setInsurance(insurance);
        patientRepository.save(patient);
        return patient;
    }
    @Transactional
    public Patient disassociateInsurance(Long patient_id){
        Patient patient = patientRepository.findById(patient_id).orElseThrow(()-> new RuntimeException("patient not found"));
        patient.setInsurance(null);
        return patient;
    }

}
