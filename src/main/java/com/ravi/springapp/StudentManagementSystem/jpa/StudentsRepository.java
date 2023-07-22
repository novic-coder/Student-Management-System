package com.ravi.springapp.StudentManagementSystem.jpa;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Integer> {

}
