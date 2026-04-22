package com.hospital.system.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String reason;
    @Column(nullable = false)
    private LocalDateTime appointmentTime;
    @ManyToOne
    @JoinColumn(name = "Patient_id" , nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "Doctor_id",nullable = false)
    private Doctor doctor;
}
