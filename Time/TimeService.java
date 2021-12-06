package com.example.demo.Time;


import com.example.demo.appointment.Appointment;
import com.example.demo.appointment.AppointmentRepository;
import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import com.example.demo.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TimeService {



    private final TimeRepository timeRepository;

    private final DoctorRepository doctorRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository, DoctorRepository doctorRepository) {
        this.timeRepository = timeRepository;
        this.doctorRepository=doctorRepository;
    }


    public List<Time> getTimes(){
        return timeRepository.findAll();
    }

    public Time getTime(String id){
        Long time_id = Long.parseLong(id);
        return timeRepository.findById(time_id).orElse(null);
    }

//    public Time createTime(Time time){
//        return timeRepository.save(time);
//    }


//    public void updateTime(String id, Time data){
//        Long time_id = Long.parseLong(id);
//        Time time = timeRepository.findById(time_id).orElse(null);
//
//        if (time != null){
//
//            timeRepository.save(time);
//        }
//
//    }

    public Time saveTime(Time time, Long idDoctor){
        Doctor doctor=doctorRepository.findById(idDoctor).orElse(null);
        time.setDoctor(doctor);

        return timeRepository.save(time);
    }

}
