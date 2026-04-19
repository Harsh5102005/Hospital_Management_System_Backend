package com.hospital.system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    @OneToOne
    private Doctor headDoctor;
    @ManyToMany
    private Set<Doctor> doctors= new HashSet<>();
}
