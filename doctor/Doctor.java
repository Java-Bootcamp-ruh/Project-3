package com.example.demo.doctor;

import com.example.demo.Time.Time;
import com.example.demo.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoctor;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String specialty;
    private String gender;

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments=new ArrayList<>();

  


    @OneToMany(mappedBy = "doctor")
    private List<Time> timeList=new ArrayList<>();
    
    public Doctor() {
    }

    public Doctor(Long idDoctor, String name, String username, String password, String specialty, String gender, Collection<Appointment> appointments, List<Time> timeList) {
        this.idDoctor = idDoctor;
        this.name = name;

        this.username = username;
        this.password = password;
        this.specialty = specialty;
        this.gender = gender;
        this.appointments = appointments;
        this.timeList = timeList;
    }

    public Long getidDoctor() {
        return idDoctor;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getGender() {
        return gender;
    }

    public void setidDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Time> gettimeList() {
        return timeList;
    }

    public void settimeList(List<Time> timeList) {
        this.timeList = timeList;
    }
}
