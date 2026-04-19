package com.hospital.system.service;

import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class patientService {
    private final PatientRepository patientRepository;
    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }


}
