package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Student;
import com.uniprojects.schoolsystem.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> list(){
        return studentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student get(@PathVariable Long id){
        return studentRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping("/login/{login}")
    public Student get(@PathVariable String login){
        return studentRepository.findByLogin(login);
    }

    @GetMapping
    @RequestMapping("/login/{login}/{pass}")
    public Student get(@PathVariable String login, @PathVariable String pass){
        return studentRepository.findByLoginAndPass(login,pass);
    }

    @PostMapping
    public Student create(@RequestBody final Student student){
        return studentRepository.saveAndFlush(student);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        studentRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Student update(@PathVariable Long id, @RequestBody Student student){
        //add validation?
        Student existingStudent = studentRepository.getReferenceById(id);
        BeanUtils.copyProperties(student,existingStudent,"student_id");
        return studentRepository.saveAndFlush(existingStudent);
    }
}
