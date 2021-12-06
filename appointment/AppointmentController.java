package com.example.demo.appointment;

import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientRepository;
import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(path="appointments")

public class AppointmentController {


    private final AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;


    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable String id){
        return appointmentService.getAppointment(id);

    }



    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id){
        appointmentService.deleteAppointment(id);

    }


    @PostMapping()
    public Appointment addOne(@RequestBody Form form){
        return appointmentService.saveAppointment(form.getAppointment(),form.getIdPatient(),form.getIdDoctor(),form.getIdTime());
    }

    }

class Form{
    private Appointment appointment;
    private Long idPatient;
    private Long idDoctor;
    private Long idTime;

    public Long getIdDoctor() {return idDoctor;}
    public Appointment getAppointment(){return appointment;}
    public Long getIdPatient(){return idPatient;}
    public Long getIdTime() {return idTime;}



}


