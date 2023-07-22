package com.ravi.springapp.StudentManagementSystem;

import com.ravi.springapp.StudentManagementSystem.coursesService.Courses;
import com.ravi.springapp.StudentManagementSystem.jpa.CoursesRepository;
import com.ravi.springapp.StudentManagementSystem.jpa.StudentsRepository;
import com.ravi.springapp.StudentManagementSystem.studentservice.StudentDaoService;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	CoursesRepository coursesRepository;


	private StudentDaoService daoService;

	//mocking the Student Repository
	@MockBean
	private StudentsRepository studentsRepository;

	@org.junit.Test
	public void getAllStudentsTest(){
		when(studentsRepository.findAll()).thenReturn(Stream
				.of(new Students(123456789,"Ravi Kumar", "700429081", LocalDate.now().minusYears(26)),
						new Students(234567891,"Anushree Shettigar", "700429082", LocalDate.now().minusYears(28))).collect((Collectors.toList())));
		assertEquals(2,studentsRepository.findAll().size());

	}

	@org.junit.Test
	public void getStudentsByIdTest(){
		int Id  = 123456789;
		when(studentsRepository.findAll()).thenReturn(Stream
				.of(new Students(123456789,"Ravi Kumar", "700429081", LocalDate.now().minusYears(26))).collect(Collectors.toList()));
		Assert.assertNotEquals(123,studentsRepository.findById(Id));

	}


	@org.junit.Test
	public void saveStudentTest(){
		Students students = new Students(123,"Rudra","908070600", LocalDate.now().minusYears(26));
		when(studentsRepository.save(students)).thenReturn(students);
		assertEquals(students,studentsRepository.save(students));
	}

	@org.junit.Test
	public void deleteStudent(){
		Students students = new Students(1234,"Reyansh","90876543211", LocalDate.now().minusYears(26));
		studentsRepository.delete(students);
		verify(studentsRepository,times(1)).delete(students);
	}


	/*@Test
	public void testCreateStudent(){
		Students student1 = new Students();
		student1.setStudentId(12345);
		student1.setStudentName("Jayshree");
		student1.setPhoneNumber("7004290908");
		student1.setDateOfBirth(LocalDate.now().minusYears(34));
		studentsRepository.save(student1);
		assertNotNull(studentsRepository);
	}

	@Test
	public void testCourseCreation(){
		Courses courses = new Courses();
		courses.setcourseId(123);
		courses.setCourseName("Spring boot ");
		courses.setCourseCost(6000);
		courses.setCourseDescription("Spring boot JPA ny 28 min");
		coursesRepository.save(courses);
		assertNotNull(coursesRepository);
	}*/
	// find all students
	@Test
	public void readAllStudents(){
		List<Students> students = studentsRepository.findAll();
	}
	// find all courses
	@Test
	public void readAllCourses(){
		List<Courses> courses = coursesRepository.findAll();
	}

	/*// test students by Id
	@Test
	public  void testStudentbyId(){
		Students student1 = studentsRepository.findById(102).get();
		System.out.println(student1);
		assertEquals("Jayshree", student1.getStudentName());
	}

	// Test Course by id
	@Test
	public  void testCoursebyId(){
		Courses courses = coursesRepository.findById(302).get();
		System.out.println(courses);
		assertEquals("Spring boot", courses.getCourseName());
	}

	// Update test case
	@Test
	public void testUpdateForStudent(){
		Students students = studentsRepository.findById(102).get();
		students.setPhoneNumber("0223029772");
		studentsRepository.save(students);
		assertNotEquals("7004290831", studentsRepository.findById(102).get().getPhoneNumber());
	}

	@Test
	public void testUpdteForCourse(){
		Courses courses = coursesRepository.findById(302).get();
		courses.setCourseDescription("Spring boot is used for building quick application");
		coursesRepository.save(courses);
		assertNotEquals(5000,coursesRepository.findById(302).get().getCourseCost());
	}

	// delete the test

	@Test
	public void deleteStudentTest(){
		Students students = studentsRepository.findById(502).get();
		studentsRepository.deleteById(502);
	}

	@Test
	public void deleteCourse(){
		coursesRepository.deleteById(302);

	}
*/


}
