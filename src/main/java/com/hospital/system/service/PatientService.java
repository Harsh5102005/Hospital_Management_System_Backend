package com.hospital.system.service;

import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.PatientRepository;
import com.hospital.system.dto.AppointmentResponseDto;
import com.hospital.system.dto.PatientRequestDto;
import com.hospital.system.dto.PatientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientResponseDto createPatient(PatientRequestDto patient){
        Patient patient1=new Patient();
            patient1.setId(patient.getId());
            patient1.setGender(patient.getGender());
            patient1.setName(patient.getName());
            patient1.setEmail(patient.getEmail());
            patient1.setBirthdate(patient.getBirthdate());
            Patient patient2= patientRepository.save(patient1);
            return mapToDto(patient2);
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
        List<AppointmentResponseDto> appointmentResponseDtos = patient.getAppointment()
                .stream()
                .map(app -> {
                    AppointmentResponseDto a = new AppointmentResponseDto();
                    a.setId(app.getId());
                    a.setReason(app.getReason());
                    a.setAppointmentTime(app.getAppointmentTime());
                    a.setPatientId(patient.getId());
                    return a;
                })
                .toList();

        patientResponseDto.setAppointments(appointmentResponseDtos);
        return patientResponseDto;
    }

}
