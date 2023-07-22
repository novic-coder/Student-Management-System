package com.ravi.springapp.StudentManagementSystem.controller;

import com.ravi.springapp.StudentManagementSystem.coursesService.Courses;
import com.ravi.springapp.StudentManagementSystem.jpa.CoursesRepository;
import com.ravi.springapp.StudentManagementSystem.jpa.StudentsRepository;
import com.ravi.springapp.StudentManagementSystem.studentservice.StudentNotFound;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentsJPAResource {

    private StudentsRepository repository;

    private CoursesRepository coursesRepository;

    public StudentsJPAResource( StudentsRepository repository, CoursesRepository coursesRepository) {
        this.repository =repository;
        this.coursesRepository =  coursesRepository;
    }

    // URI/API to get the students

    @GetMapping("/jpa/students")
    public List<Students> retrieveAllStudents(){
        return repository.findAll();
    }

    // Get Student by Id

    /*@GetMapping("/students/{StudentIdentityNo}")
    public  Students findById(@PathVariable int StudentIdentityNo){
        return studentService.findStudentbyId(StudentIdentityNo);
    }*/

    // when Student is not found - Not Found Exception

    @GetMapping("/jpa/students/{StudentIdentityNo}")
    public Optional<Students> findById(@PathVariable int StudentIdentityNo){
        Optional<Students> student = repository.findById(StudentIdentityNo);
        if (student == null)
            throw new StudentNotFound("StudentId: "+StudentIdentityNo);
        return student;

    }


    // Post request to add new student

    @PostMapping("/jpa/students")
//    public void createNewStudent(@RequestBody Students students){
//        studentService.addNewStudent(students);
    //  -Enhancing the post method to return correct HTTP status and Code and Location
    public ResponseEntity<Students> createNewStudent(@RequestBody Students students){

        Students savedStudent = repository.save(students);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentsId}")
                .buildAndExpand(savedStudent.getStudentId())
                .toUri();
        return  ResponseEntity.created(location).build();

    }

    // Delete Api

    @DeleteMapping("/jpa/students/{studentIdentityNo}")
    public void deleteStudent(@PathVariable int studentIdentityNo){
        repository.deleteById(studentIdentityNo);
    }

    // Get API to have list of all the courses for a student

    @GetMapping("/jpa/students/{studentIdentityNo}/course")
    public List<Courses> retrieveCoursesForStudent(@PathVariable int studentIdentityNo){
        Optional<Students> student = repository.findById(studentIdentityNo);
        if (student == null)
            throw new StudentNotFound("StudentId: "+studentIdentityNo);
       return student.get().getCourses();

    }


    // Post API in order to create a new Course or add a course

    @PostMapping("/jpa/students/{studentIdentityNo}/course")
    public ResponseEntity<Courses> createCoursesForStudent(@PathVariable int studentIdentityNo, @RequestBody Courses courses){
        Optional<Students> student = repository.findById(studentIdentityNo);
        if (student == null)
            throw new StudentNotFound("StudentId: "+studentIdentityNo);

        courses.setStudent(student.get());

        Courses saveCourse = coursesRepository.save(courses);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentsId}")
                .buildAndExpand(saveCourse.getcourseId())
                .toUri();
        return ResponseEntity.created(location).build();

    }


}
