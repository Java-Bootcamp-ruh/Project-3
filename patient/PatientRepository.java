package com.example.demo.patient;
import com.example.demo.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    public Patient findByUsername(String username);
}
