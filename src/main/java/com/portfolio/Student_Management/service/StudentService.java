package com.portfolio.Student_Management.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.Student_Management.entity.StudentEntity;

public interface StudentService {
    List<StudentEntity> getAllStudents();
    Optional<StudentEntity> getStudentById(Long id);
    StudentEntity createStudent(StudentEntity student);
    StudentEntity updateStudent(Long id, StudentEntity student);
    void deleteStudent(Long id);
}
