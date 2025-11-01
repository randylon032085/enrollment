package com.project.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.enrollment.model.SubjectModel;
import com.project.enrollment.repositories.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjRepo;

    public void createSubject(@RequestBody SubjectModel newSubject) {
        subjRepo.save(newSubject);

    }

    public List<SubjectModel> getAllSubject() {
        return subjRepo.findAll();
    }

    public List<SubjectModel> searchSubject(@RequestParam String subject) {
        return subjRepo.findBySubjectnameContainingIgnoreCase(subject);
    }
}
