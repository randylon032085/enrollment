package com.project.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.enrollment.model.TeacherModel;
import com.project.enrollment.repositories.TeacherRepository;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository teacherRep;

    //create teacher
    public void createTeacher(@RequestBody TeacherModel newTeacher){
        teacherRep.save(newTeacher);
    }
    //get all teacher
    public List<TeacherModel> getAllTeacher(){
        return teacherRep.findAll();
    }


    //delete teacher by id
    public void deleteTeacherById(@PathVariable int id ){
        teacherRep.deleteById(id);
    }


    //delete all teacher
    public void deleteAllTeacher(){
        teacherRep.deleteAll();
    
    }

    //update teacher by id
    public void updateTeacherById(@PathVariable int id,@RequestBody TeacherModel updatedTeacher){
      List<TeacherModel> allTeacher = teacherRep.findAll();
      
      for(TeacherModel allTeach : allTeacher){
        if (allTeach.getId()==id) {
            allTeach.setFirstname(updatedTeacher.getFirstname());
            allTeach.setLastname(updatedTeacher.getLastname());
            teacherRep.save(allTeach);
        }}
    }

    // //find teacher by id
    // public List<TeacherModel> findTeacherById(@PathVariable int id){
    //     return teacherRep.findAllById(ids);
    // }

    //search teacher
    public List<TeacherModel> searchTeacher(@RequestParam String name){
        return teacherRep.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(name, name);
    }

}
