package com.hospital.system.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private LocalDate birthdate;
    @Column(nullable = false)
    private String email;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE , CascadeType.PERSIST},orphanRemoval = true )
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointment= new ArrayList<>();
}
