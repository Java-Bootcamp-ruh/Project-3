package com.example.demo.patient;
import com.example.demo.appointment.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

            public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatient(String userName){
        return patientRepository.findByUsername(userName);
    }


    public void updatePatient(String id, Patient data){
        Long patient_id = Long.parseLong(id);
        Patient patient = patientRepository.findById(patient_id).orElse(null);

        if (patient != null){
            patient.setName(data.getName());
            patient.setGender(data.getGender());
            patient.setBloodType(data.getBloodType());
            patient.setDOB(data.getDOB());
            patient.setHeight(data.getHeight());
            patient.setUsername(data.getUsername());
            patient.setPhoneNO(data.getPhoneNO());
            patient.setWeight(data.getWeight());
            patient.setPassword(data.getPassword());


            patientRepository.save(patient);
        }

    }

    public  Patient register(Patient patient){
        return patientRepository.save(patient);
    }

public List<Appointment> getAllAppointment(String  username){
        Patient patient=patientRepository.findByUsername(username);
        return patient.getAppointments();
}

    public Patient login(Patient data){
     Patient patient=   patientRepository.findByUsername(data.getUsername());
     if(patient.getPassword().equals(data.getPassword())){
         return patient;
     }
        return null;
    }



}
