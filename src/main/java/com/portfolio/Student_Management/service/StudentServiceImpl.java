package com.portfolio.Student_Management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.portfolio.Student_Management.entity.StudentEntity;
import com.portfolio.Student_Management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Optional<StudentEntity> getStudentById(Long id) {
        return repo.findById(id);
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return repo.save(student);
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existing = repo.findById(id).orElseThrow();
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setAddress(student.getAddress());
        existing.setDob(student.getDob());
        existing.setGuardianName(student.getGuardianName());
        return repo.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
    
}
