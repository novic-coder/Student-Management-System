package com.ravi.springapp.StudentManagementSystem.studentservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravi.springapp.StudentManagementSystem.coursesService.Courses;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "students_details") // requires Jpa to manage the entity
public class Students {

    // Static Filetering

    @Id
    @GeneratedValue
    private Integer studentId;
    private String studentName;

    // Getting response without Student Contact Details - Static 

    private String phoneNumber;
    private LocalDate dateOfBirth;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Courses> courses;


    public Students(){

    }

    public Students(Integer studentId, String studentName, String phoneNumber, LocalDate dateOfBirth) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}
