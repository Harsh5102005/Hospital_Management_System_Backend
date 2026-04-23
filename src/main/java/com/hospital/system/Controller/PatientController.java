package com.hospital.system.Controller;

import com.hospital.system.Entity.Patient;
import com.hospital.system.dto.PatientRequestDto;
import com.hospital.system.dto.PatientResponseDto;
import com.hospital.system.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public List<PatientResponseDto> getPatients(){
        return patientService.getPatients();
    }
    @GetMapping("/{id}")
    public PatientResponseDto getpatient(@PathVariable Long id){
        return patientService.getbyId(id);
    }
    @PostMapping
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto patient){
       PatientResponseDto resp= patientService.createPatient(patient);
       return ResponseEntity.status(201).body(resp);
    }


}
