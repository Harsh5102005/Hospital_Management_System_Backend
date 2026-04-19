package com.hospital.system.service;

import com.hospital.system.Entity.Appointment;
import com.hospital.system.Entity.Doctor;
import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.AppointmentRepository;
import com.hospital.system.Repository.DoctorRepository;
import com.hospital.system.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
   private final PatientRepository patientRepository;
   private final DoctorRepository doctorRepository;
   @Transactional
   public Appointment createAppointment(Appointment appointment , Long Doctor_id, Long patient_id){
       Doctor doctor = doctorRepository.findById(Doctor_id).orElseThrow();
       Patient patient = patientRepository.findById(patient_id).orElseThrow();
       appointment.setDoctor(doctor);
       appointment.setPatient(patient);
       patient.getAppointment().add(appointment);
       appointmentRepository.save(appointment);
       return appointment;

   }
   @Transactional
    public Appointment rescheduleAppointment(Long  appointment_id, Long Doctor_id){
       Doctor doctor = doctorRepository.findById(Doctor_id).orElseThrow();
       Appointment appointment = appointmentRepository.findById(appointment_id).orElseThrow();
       appointment.setDoctor(doctor);
       doctor.getAppointments().add(appointment);
            return appointment;

   }
}
