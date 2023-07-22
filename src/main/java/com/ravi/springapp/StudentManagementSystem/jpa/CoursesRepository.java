package com.ravi.springapp.StudentManagementSystem.jpa;
import com.ravi.springapp.StudentManagementSystem.coursesService.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}
