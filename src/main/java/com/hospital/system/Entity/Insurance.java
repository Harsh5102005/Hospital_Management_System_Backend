package com.hospital.system.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String policyNo;
    @Column(nullable = false)
    private String provider;
    @Column(nullable = false)
    private LocalDate endDate;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createDate;
    @OneToOne(mappedBy = "insurance")
    private Patient patient;
}
