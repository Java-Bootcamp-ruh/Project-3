package com.example.demo.appointment;


import com.example.demo.Time.Time;
import com.example.demo.doctor.Doctor;
import com.example.demo.patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idAppointment;
//title


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    @JoinColumn(name = "idPatient",referencedColumnName = "idPatient")
    @JsonIgnore
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;

//,referencedColumnName = "idDoctor"
    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
        time.setAvailable(false);

    }


        public Appointment(){}
        public Appointment(Long idAppointment) {
            this.idAppointment = idAppointment;
        }


        public Long getIdAppointment() {
            return idAppointment;
        }

        public void setIdAppointment(Long idAppointment) {
            this.idAppointment = idAppointment;
        }

    public Patient getPatient() {
        return patient;
    }
        @Override
        public String toString() {
            return "Appointment{" +
                    "idAppointment=" + idAppointment +
                    '}';
        }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

