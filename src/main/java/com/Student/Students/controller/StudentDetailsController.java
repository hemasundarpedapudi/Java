package com.Student.Students.controller;

import com.Student.Students.entity.StudentDetailsEntity;
import com.Student.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")  // Define the base URL for all student-related operations
public class StudentDetailsController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping
    public StudentDetailsEntity addStudent(@RequestBody StudentDetailsEntity studentDetailsEntity) {
        return studentService.addStudent(studentDetailsEntity);
    }

    // Get all students
    @GetMapping
    public List<StudentDetailsEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public StudentDetailsEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello welcome to Spring-Boot";
    }

    // Update student details
    @PutMapping("/{id}")
    public StudentDetailsEntity updateStudent(@PathVariable Long id, @RequestBody StudentDetailsEntity studentDetailsEntity) {
        return studentService.updateStudentDetails(id, studentDetailsEntity);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/filtered")
    public List<StudentDetailsEntity> getFilteredStudents() {
        return studentService.getFilteredAndSortedStudents();  // Call the method you added in the service layer
    }
}
