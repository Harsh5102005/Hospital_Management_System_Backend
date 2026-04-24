package com.hospital.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceResponseDto {
    private Long id;
    private String policyNo;
    private String provider;
    private LocalDate endDate;
    private LocalDate createDate;
}

