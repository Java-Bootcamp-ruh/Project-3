package com.example.demo.doctor;

import com.example.demo.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Doctor findByUsername(String username);
    public Doctor findByName(String name);
    public List<Doctor> findBySpecialty(String specialty);

}
