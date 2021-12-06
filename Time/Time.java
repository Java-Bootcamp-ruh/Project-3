package com.example.demo.Time;


import com.example.demo.appointment.Appointment;
import com.example.demo.doctor.Doctor;
import com.example.demo.patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTime;
    private String appointmentTime;
    private Boolean isAvailable = true ;


//,referencedColumnName = "idDoctor"

    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    @JoinColumn(name = "idDoctor")
    @JsonIgnore
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "time")
    private Appointment appointment;


    public Time(){}

    public Time(Long idTime, String appointmentTime, Boolean isAvailable) {
        this.idTime = idTime;
        this.appointmentTime = appointmentTime;
        this.isAvailable = isAvailable;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Time{" +
                "idTime=" + idTime +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", isAvailable=" + isAvailable +
                ", doctor=" + doctor +
                '}';
    }
}
