package com.hospital.system.dto;

import com.hospital.system.Entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {
    private Long id;
    private String name;
    private String Gender;
    private LocalDate birthdate;
    private String email;
    private List<AppointmentDto> appointments;

}
