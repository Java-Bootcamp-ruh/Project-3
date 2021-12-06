package com.example.demo.doctor;

import com.example.demo.Time.Time;
import com.example.demo.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping(path="doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable String id, @RequestBody Doctor data){
        doctorService.updateDoctor(id, data);
    }
    @GetMapping("/time/{username}")
    public List<Time>getTime(@PathVariable String username){
      return   doctorService.getTime(username);

    }

    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @GetMapping("/{username}")
    public Doctor findDoctor(@PathVariable String username){
        return doctorService.findDoctor(username);
    }

    @PostMapping
    public Doctor register(@RequestBody Doctor doctor){
        return doctorService.register(doctor);
    }

    @PostMapping("/login")
    public  Doctor login(@RequestBody Doctor doctor){
        return doctorService.login(doctor);
    }

    @RequestMapping(value = "specialty/{specialty}")
    public List<Doctor> getDoctorBySpecialty(@PathVariable String specialty){
        return doctorService.getSpecialty(specialty);
    }
}
