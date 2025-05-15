package com.portfolio.Student_Management.repository;

import com.portfolio.Student_Management.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
}
