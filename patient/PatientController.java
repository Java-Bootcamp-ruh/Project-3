package com.example.demo.patient;

import com.example.demo.appointment.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="patients")
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();

    }

    @GetMapping("/allAppointment/{username}")
    public List<Appointment> getAllAppointment(@PathVariable String username){
        return patientService.getAllAppointment(username);
    }

    @GetMapping("/{username}")
    public Patient getPatient(@PathVariable String username){
        return patientService.getPatient(username);
    }

    @PostMapping
    public Patient register(@RequestBody Patient patient){
        return patientService.register(patient);
    }

    @PostMapping("/login")
    public  Patient login(@RequestBody Patient patient){
        return patientService.login(patient);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody Patient data){
        patientService.updatePatient(id, data);
    }


}


