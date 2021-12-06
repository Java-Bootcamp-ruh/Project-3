package com.example.demo.doctor;

import com.example.demo.appointment.Appointment;
import com.example.demo.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;
import com.example.demo.Time.Time;
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
//
//    public Doctor getDoctor(String id){
//        Long doctor_id = Long.parseLong(id);
//        return doctorRepository.findById(doctor_id).orElse(null);
//    }

    public void updateDoctor(String id, Doctor data){
        Long doctor_id = Long.parseLong(id);
        Doctor doctor= doctorRepository.findById(doctor_id).orElse(null);

        if (doctor != null){
            doctor.setName(data.getName());
            doctor.setGender(data.getGender());
            doctor.setUsername(data.getUsername());
            doctor.setPassword(data.getPassword());
            doctor.setSpecialty(data.getSpecialty());
            doctor.settimeList(data.gettimeList());

        }

    }

   public List < Time > getTime(String username){
       Doctor doctor= doctorRepository.findByUsername(username);
       return doctor.gettimeList();
   }

   public Doctor getDoctor1(String name){
       return doctorRepository.findByName(name) ;
}

    public List<Doctor> getSpecialty(String data){
         return doctorRepository.findBySpecialty(data);

    }

    public Doctor register(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor findDoctor (String username){
        Doctor doctor=   doctorRepository.findByUsername(username);
        return doctor;
    }


    public Doctor login(Doctor data){
        Doctor doctor=   doctorRepository.findByUsername(data.getUsername());
        if(doctor.getPassword().equals(data.getPassword())){
            return doctor;
        }
        return null;
    }

}
