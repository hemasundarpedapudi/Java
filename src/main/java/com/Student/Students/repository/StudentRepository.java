package com.Student.Students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Student.Students.entity.StudentDetailsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetailsEntity, Long> {


}
