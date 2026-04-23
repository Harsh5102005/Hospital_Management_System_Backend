package com.hospital.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDto {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private LocalDate birthdate;
}
