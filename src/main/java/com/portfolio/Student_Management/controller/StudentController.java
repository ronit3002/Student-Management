package com.portfolio.Student_Management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.Student_Management.entity.StudentEntity;
import com.portfolio.Student_Management.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping
    public List<StudentEntity> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getById(@PathVariable Long id){
        return service.getStudentById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());  
    }

    @PostMapping
    public StudentEntity create(@RequestBody StudentEntity student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    public StudentEntity update(@PathVariable Long id, @RequestBody StudentEntity student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
