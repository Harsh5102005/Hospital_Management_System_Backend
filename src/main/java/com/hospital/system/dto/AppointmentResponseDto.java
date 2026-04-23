package com.hospital.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentResponseDto {
    private Long id;
    private String reason;
    private LocalDateTime appointmentTime;
    private Long patientId;
}
