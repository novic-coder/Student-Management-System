package com.ravi.springapp.StudentManagementSystem.controller;


import com.ravi.springapp.StudentManagementSystem.studentservice.StudentDaoService;
import com.ravi.springapp.StudentManagementSystem.studentservice.StudentNotFound;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentsResource {

    private StudentDaoService studentService;

    public StudentsResource (StudentDaoService studentService) {
        this.studentService = studentService;
    }

    // URI/API to get the students

    @GetMapping("/students")
    public List<Students> retrieveAllStudents(){
        return studentService.findAll();
    }

    // Get Student by Id

    /*@GetMapping("/students/{StudentIdentityNo}")
    public  Students findById(@PathVariable int StudentIdentityNo){
        return studentService.findStudentbyId(StudentIdentityNo);
    }*/

    // when Student is not found - Not Found Exception

    @GetMapping("/students/{StudentIdentityNo}")
    public Students findById(@PathVariable int StudentIdentityNo){
        Students student = studentService.findStudentbyId(StudentIdentityNo);

        if (student == null)
            throw new StudentNotFound("StudentId: "+StudentIdentityNo);
        return student;
    }


    // Post request to add new student

    @PostMapping("/students")
//    public void createNewStudent(@RequestBody Students students){
//        studentService.addNewStudent(students);
    //  -Enhancing the post method to return correct HTTP status and Code and Location
    public ResponseEntity<Students> createNewStudent(@RequestBody Students students){

        Students savedStudent = studentService.addNewStudent(students);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentsId}")
                .buildAndExpand(savedStudent.getStudentId())
                .toUri();
        return  ResponseEntity.created(location).build();

    }

    // Delete Api

    @DeleteMapping("/students/{studentIdentityNo}")
    public void deleteStudent(@PathVariable int studentIdentityNo){
        studentService.deleteStudentbyId(studentIdentityNo);
    }

}
