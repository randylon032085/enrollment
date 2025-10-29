package com.project.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.enrollment.model.StudentModel;
import com.project.enrollment.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    //create student
    public void createStudent(@RequestBody StudentModel newStudent){
        studentRepo.save(newStudent);
    }

    //get all student
    public List<StudentModel> getAllStudent(){
        return studentRepo.findAll();
    }

    public void deleteStudentById(@PathVariable int id){
        studentRepo.deleteById(id);
    }

    public void deleteAllStudent(){
        studentRepo.deleteAll();
    }

    public void updateStudentById(@PathVariable int id, @RequestBody StudentModel updatedStudent){
        List<StudentModel> allStudent = studentRepo.findAll();

        for(StudentModel allStud: allStudent){
            if (allStud.getId()==id) {
                allStud.setFirstname(updatedStudent.getFirstname());
                allStud.setLastname(updatedStudent.getLastname());
                studentRepo.save(allStud);

            }
        }
    }

    public List<StudentModel> searchStudent(@RequestParam String name){
        return studentRepo.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(name, name);

    }
}

