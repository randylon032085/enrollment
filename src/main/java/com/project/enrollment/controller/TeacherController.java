package com.project.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.enrollment.model.TeacherModel;
import com.project.enrollment.service.TeacherService;

@RestController
@RequestMapping(path="/v3/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherServ;


    @PostMapping
    public void createTeacher(@RequestBody TeacherModel newTeacher){
        teacherServ.createTeacher(newTeacher);
    }
      @GetMapping
    public List<TeacherModel> getAllTeacher(){
        return teacherServ.getAllTeacher();
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable int id){
        teacherServ.deleteTeacherById(id);
    }

    @DeleteMapping
    public void deleteAllTeacher(){
        teacherServ.deleteAllTeacher();
        
    }

    @PutMapping("/{id}")
    public void updateTeacherById(@PathVariable int id, @RequestBody TeacherModel updatedTeacher){
        teacherServ.updateTeacherById(id, updatedTeacher);
    }

    @GetMapping("/search")
    public List<TeacherModel> searchTeacher(@RequestParam String name){
        return teacherServ.searchTeacher(name);
    }

    
    
}
