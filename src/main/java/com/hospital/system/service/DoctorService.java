package com.hospital.system.service;

import com.hospital.system.Entity.Doctor;
import com.hospital.system.Repository.DoctorRepository;
import com.hospital.system.dto.DoctorRequestDto;
import com.hospital.system.dto.DoctorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorResponseDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(this::mapToDto)
                .toList();
    }

    public DoctorResponseDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        return mapToDto(doctor);
    }

    public DoctorResponseDto createDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setSpecialty(doctorRequestDto.getSpecialty());
        doctor.setEmail(doctorRequestDto.getEmail());
        Doctor savedDoctor = doctorRepository.save(doctor);
        return mapToDto(savedDoctor);
    }

    public DoctorResponseDto updateDoctor(Long id, DoctorRequestDto doctorRequestDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        doctor.setName(doctorRequestDto.getName());
        doctor.setSpecialty(doctorRequestDto.getSpecialty());
        doctor.setEmail(doctorRequestDto.getEmail());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return mapToDto(updatedDoctor);
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }

    private DoctorResponseDto mapToDto(Doctor doctor) {
        DoctorResponseDto dto = new DoctorResponseDto();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setEmail(doctor.getEmail());
        return dto;
    }
}

