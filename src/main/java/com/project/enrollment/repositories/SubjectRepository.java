package com.project.enrollment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enrollment.model.SubjectModel;

public interface SubjectRepository extends JpaRepository<SubjectModel, Integer> {
    List<SubjectModel> findBySubjectnameContainingIgnoreCase(String subjectname);
}
