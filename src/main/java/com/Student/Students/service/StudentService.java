package com.Student.Students.service;


import com.Student.Students.entity.StudentDetailsEntity;
import com.Student.Students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService {


     StudentDetailsEntity addStudent(StudentDetailsEntity studentDetailsEntity);
     List<StudentDetailsEntity> getAllStudents();
     StudentDetailsEntity getStudentById(Long id);
     StudentDetailsEntity updateStudentDetails(Long id, StudentDetailsEntity studentDetailsEntity);
    void deleteStudent(Long id);
    List<StudentDetailsEntity> getFilteredAndSortedStudents();
}
