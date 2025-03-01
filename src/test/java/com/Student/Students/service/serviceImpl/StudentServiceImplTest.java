package com.Student.Students.service.serviceImpl;

import com.Student.Students.entity.StudentDetailsEntity;
import com.Student.Students.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private StudentDetailsEntity student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mock objects
        student = new StudentDetailsEntity();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setDateOfBirth(LocalDate.of(1995, 5, 15)); // Student aged 30 as of today
    }

    @Test
    public void testAddStudent() {
        when(studentRepository.save(student)).thenReturn(student);

        StudentDetailsEntity savedStudent = studentService.addStudent(student);

        assertNotNull(savedStudent);
        assertEquals("John", savedStudent.getFirstName());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(student));

        var students = studentService.getAllStudents();

        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testGetStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        StudentDetailsEntity foundStudent = studentService.getStudentById(1L);

        assertNotNull(foundStudent);
        assertEquals(1L, foundStudent.getId());
        assertEquals("John", foundStudent.getFirstName());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetStudentById_NotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> studentService.getStudentById(1L));

        assertEquals("StudentDetails Not found", exception.getMessage());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateStudentDetails() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        student.setFirstName("Jane");
        student.setLastName("Smith");

        StudentDetailsEntity updatedStudent = studentService.updateStudentDetails(1L, student);

        assertEquals("Jane", updatedStudent.getFirstName());
        assertEquals("Smith", updatedStudent.getLastName());
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetFilteredAndSortedStudents() {
        List<StudentDetailsEntity> students = List.of(student);
        when(studentRepository.findAll()).thenReturn(students);

        var filteredAndSortedStudents = studentService.getFilteredAndSortedStudents();

        assertEquals(1, filteredAndSortedStudents.size());
        assertEquals("John", filteredAndSortedStudents.get(0).getFirstName());
        verify(studentRepository, times(1)).findAll();
    }
}
