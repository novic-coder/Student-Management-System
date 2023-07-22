package com.ravi.springapp.StudentManagementSystem.junitMokito;

import com.ravi.springapp.StudentManagementSystem.jpa.StudentsRepository;
import com.ravi.springapp.StudentManagementSystem.studentservice.StudentDaoService;
import com.ravi.springapp.StudentManagementSystem.studentservice.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestingwithMokitoTest {

    // Importing the Student Service
    private StudentDaoService daoService;

    //mocking the Student Repository
    @MockBean
    private StudentsRepository studentsRepository;

    @Test
    public void getAllStudentsTest(){
        when(studentsRepository.findAll()).thenReturn(Stream
                .of(new Students(123456789,"Ravi Kumar", "700429081", LocalDate.now().minusYears(26)),
                        new Students(234567891,"Anushree Shettigar", "700429082", LocalDate.now().minusYears(28))).collect((Collectors.toList())));
        assertEquals(2,studentsRepository.findAll().size());

    }

    @Test
    public void getStudentsByIdTest(){
        int Id  = 123456789;
        when(studentsRepository.findAll()).thenReturn(Stream
                .of(new Students(123456789,"Ravi Kumar", "700429081", LocalDate.now().minusYears(26))).collect(Collectors.toList()));
        assertNotEquals(123,studentsRepository.findById(Id));

    }


    @Test
    public void saveStudentTest(){
        Students students = new Students(123,"Rudra","908070600", LocalDate.now().minusYears(26));
        when(studentsRepository.save(students)).thenReturn(students);
        assertEquals(students,studentsRepository.save(students));
    }

    @Test
    public void deleteStudent(){
        Students students = new Students(1234,"Reyansh","90876543211", LocalDate.now().minusYears(26));
        studentsRepository.deleteById(1234);
        verify(studentsRepository,times(1)).deleteById(1234);
    }


}
