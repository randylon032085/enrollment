package com.project.enrollment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enrollment.model.TeacherModel;


public interface TeacherRepository extends JpaRepository<TeacherModel, Integer> {
    List<TeacherModel> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);
    
}
 