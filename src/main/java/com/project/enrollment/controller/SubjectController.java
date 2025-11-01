package com.project.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.enrollment.model.SubjectModel;
import com.project.enrollment.service.SubjectService;

@RestController
@RequestMapping(path = "/v3/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjServ;

    @PostMapping
    public void createSubject(@RequestBody SubjectModel newSubject) {
        subjServ.createSubject(newSubject);
    }

    @GetMapping
    public List<SubjectModel> getAllSubject() {
        return subjServ.getAllSubject();
    }

    @GetMapping("/search")
    public List<SubjectModel> searchSub(@RequestParam String subject) {
        return subjServ.searchSubject(subject);
    }

}
