package com.ravi.springapp.StudentManagementSystem.coursesService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;

import javax.persistence.*;

// Creating a new Course Entity to connect it with data base
@Entity
public class Courses {
    @Id
    @GeneratedValue
    private  Integer courseId;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    private String courseName;

    private Integer courseCost;

    private String courseDescription;

    @ManyToOne(fetch = FetchType.LAZY ) // fetch decides wheather Association will be slowly loaded or eagerly fetched
    @JsonIgnore
    private Students student;


    public Integer getcourseId() {
        return courseId;
    }

    public void setcourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Integer courseCost) {
        this.courseCost = courseCost;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseCost=" + courseCost +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
