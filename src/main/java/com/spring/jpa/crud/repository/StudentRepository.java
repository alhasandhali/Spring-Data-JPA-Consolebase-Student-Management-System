package com.spring.jpa.crud.repository;

import com.spring.jpa.crud.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> findByStudentName(String studentName);
    List<Student> findByStudentEmail(String studentEmail);
}
