package com.Student.Students.service.serviceImpl;

import com.Student.Students.entity.StudentDetailsEntity;
import com.Student.Students.repository.StudentRepository;
import com.Student.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDetailsEntity addStudent(StudentDetailsEntity studentDetailsEntity) {
        return studentRepository.save(studentDetailsEntity);
    }

    @Override
    public List<StudentDetailsEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDetailsEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("StudentDetails Not found"));
    }

    @Override
    public StudentDetailsEntity updateStudentDetails(Long id, StudentDetailsEntity studentDetailsEntity) {
        StudentDetailsEntity exsitingStudent = getStudentById(id);
        exsitingStudent.setFirstName(studentDetailsEntity.getFirstName());
        exsitingStudent.setLastName(studentDetailsEntity.getLastName());
        exsitingStudent.setDateOfBirth(studentDetailsEntity.getDateOfBirth());
        return studentRepository.save(exsitingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDetailsEntity> getFilteredAndSortedStudents() {
        List<StudentDetailsEntity> students = studentRepository.findAll();

        return students.stream()
                .filter(student -> calculateAge(student.getDateOfBirth()) >= 25) // Filter students aged 25 and above
                .sorted((s1, s2) -> Long.compare(s2.getId(), s1.getId())) // Sort by student ID in descending order
                .collect(Collectors.toList());
    }

    // Helper method to calculate age from date of birth
    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
