package com.project.enrollment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enrollment.model.StudentModel;

public interface  StudentRepository extends JpaRepository<StudentModel, Integer>  {
    
    List<StudentModel> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);
}
