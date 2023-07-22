package com.ravi.springapp.StudentManagementSystem.studentservice;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class StudentDaoService {

    private static List<Students> students = new ArrayList<>();
    private static int countOfStudent = 0;

    static {
        students.add(new Students(++countOfStudent, "Ravi Kumar", "700429081", LocalDate.now().minusYears(26)));
        students.add(new Students(++countOfStudent, "Anushree Shettigar", "700429082", LocalDate.now().minusYears(28)));
        students.add(new Students(++countOfStudent, "Sheetal Choudhary", "700429083", LocalDate.now().minusYears(29)));
        students.add(new Students(++countOfStudent, "Hari Priya", "700429084", LocalDate.now().minusYears(24)));
        students.add(new Students(++countOfStudent, "Rajshekhara ", "700429085", LocalDate.now().minusYears(34)));
    }

    // method to find all the students

    public List<Students> findAll() {
        return students;
    }

    // Adding new Student

    public Students addNewStudent(Students student) {
        student.setStudentId(++countOfStudent);
        students.add(student);
        return student;
    }

    // Find student by Id

    public Students findStudentbyId(int StudentIdentityNo) {
        Predicate<? super Students> predicate = student -> student.getStudentId().equals(StudentIdentityNo);
        return students.stream().filter(predicate).findFirst().orElse(null);
    }

    // Implementing Delete Method to delete a user Resource

    public void deleteStudentbyId(int studentIdentityNo) {
        Predicate<? super Students> predicate = student -> student.getStudentId().equals(studentIdentityNo);
        students.removeIf(predicate);
    }
}


