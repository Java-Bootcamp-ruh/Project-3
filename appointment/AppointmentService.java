package com.example.demo.appointment;


import com.example.demo.Time.Time;
import com.example.demo.Time.TimeRepository;
import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final TimeRepository timeRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientRepository patientRepository,
                              DoctorRepository doctorRepository,
                              TimeRepository timeRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository=doctorRepository;
        this.timeRepository=timeRepository;
    }


    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(String id){
        Long appointment_id = Long.parseLong(id);
        return appointmentRepository.findById(appointment_id).orElse(null);
    }

    public Appointment createAppointment(Appointment appointment){

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(String id){
        Long appointment_id = Long.parseLong(id);
        appointmentRepository.deleteById(appointment_id);

    }

    public Appointment saveAppointment(Appointment appointment, Long idPatient,Long idDoctor,Long idTime){

        Patient patient = patientRepository.findById(idPatient).orElse(null);
        appointment.setPatient(patient);

        Doctor doctor=doctorRepository.findById(idDoctor).orElse(null);
        appointment.setDoctor(doctor);

        Time time=timeRepository.findById(idTime).orElse(null);
        appointment.setTime(time);

        return appointmentRepository.save(appointment);
    }
}
