package com.hospital.system;

import com.hospital.system.Entity.Appointment;
import com.hospital.system.Entity.Insurance;
import com.hospital.system.Entity.Patient;
import com.hospital.system.Repository.InsuranceRepository;
import com.hospital.system.service.AppointmentService;
import com.hospital.system.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class TestInsurance {

        @Autowired
        private InsuranceService insuranceService;
        @Autowired
        private AppointmentService  appointmentService;
        @Autowired
        private InsuranceRepository insuranceRepository;
    @Test
    public void test(){
        Insurance insurance= Insurance.builder()
                .policyNo("HDFC_12")
                .provider("HDFC")
                .endDate(LocalDate.of(2030,12,23))
                .build();
         Patient patient=insuranceService.assignInsurance(insurance,1L);
         System.out.println(patient);
         Patient newpationt=insuranceService.disassociateInsurance(patient.getId());
         System.out.println(newpationt);
    }
    @Test
    public void test1(){
        Appointment appointment= Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,21,14,0))
                .reason("to check for brain")
                .build();
        Appointment newappointment=appointmentService.createAppointment(appointment,2L,1L);
        System.out.println(newappointment);


    }

}
