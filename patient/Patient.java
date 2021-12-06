package com.example.demo.patient;

import com.example.demo.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "patients")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long idPatient ;


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }



    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments=new ArrayList<>();

    private String name;
    @Column(unique = true)
    private String  username;
    private String password;
    private Date DOB;
    @Column(unique = true)
    private String  phoneNO;
    private String  gender;
    private String bloodType;
    private double  weight;
    private double height;


    public Patient(){}

    public Patient(long idPatient, String name, String username, String password, Date DOB, String phoneNO, String gender, String bloodType, double weight, double height,List<Appointment> appointments) {
        this.idPatient = idPatient;
        this.name = name;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.phoneNO = phoneNO;
        this.gender = gender;
        this.bloodType = bloodType;
        this.weight = weight;
        this.height = height;
        this.appointments=appointments;
    }

    public long getId() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "idPaient=" + idPatient +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DOB=" + DOB +
                ", phoneNO='" + phoneNO + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }


}
