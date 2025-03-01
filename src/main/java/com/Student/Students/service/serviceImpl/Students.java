package com.Student.Students.service.serviceImpl;

import com.Student.Students.entity.StudentDetailsEntity;
import com.Student.Students.service.Hello;
import com.Student.Students.service.StudentService;

import java.util.List;

public class Students implements Hello, StudentService {


    @Override
    public StudentDetailsEntity addStudent(StudentDetailsEntity studentDetailsEntity) {
        return null;
    }

    @Override
    public List<StudentDetailsEntity> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentDetailsEntity getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentDetailsEntity updateStudentDetails(Long id, StudentDetailsEntity studentDetailsEntity) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public List<StudentDetailsEntity> getFilteredAndSortedStudents() {
        return List.of();
    }
}
