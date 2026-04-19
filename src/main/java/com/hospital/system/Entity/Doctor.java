package com.hospital.system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String specialty;
    @Column(nullable = false)
    String email;
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments= new HashSet<>();
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments=new ArrayList<>();



}
