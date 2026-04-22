package com.hospital.system.service;

import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.PatientRepository;
import com.hospital.system.dto.AppointmentDto;
import com.hospital.system.dto.PatientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public ResponseEntity<Patient> createPatient(Patient patient){
        patientRepository.save(patient);
        return ResponseEntity.ok().body(patient);
    }
    public List<PatientResponseDto> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(this::mapToDto)
                .toList();
    }
    public PatientResponseDto getbyId(Long id){
        return mapToDto(patientRepository.findById(id).orElseThrow());
    }
    public PatientResponseDto mapToDto(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setGender(patient.getGender());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setBirthdate(patient.getBirthdate());
        List<AppointmentDto> appointmentDtos = patient.getAppointment()
                .stream()
                .map(app -> {
                    AppointmentDto a = new AppointmentDto();
                    a.setId(app.getId());
                    a.setReason(app.getReason());
                    a.setAppointmentTime(app.getAppointmentTime());
                    a.setPatientId(patient.getId());
                    return a;
                })
                .toList();

        patientResponseDto.setAppointments(appointmentDtos);
        return patientResponseDto;
    }

}
