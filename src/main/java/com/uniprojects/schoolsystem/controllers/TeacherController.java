package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Teacher;

import com.uniprojects.schoolsystem.repositories.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> list(){
        return teacherRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Teacher get(@PathVariable Long id){
        return teacherRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping("login/{login}")
    public Teacher get(@PathVariable String login){
        return teacherRepository.findByLogin(login);
    }

    @GetMapping
    @RequestMapping("login/{login}/{pass}")
    public Teacher get(@PathVariable String login,@PathVariable String pass){
        return teacherRepository.findByLoginAndPass(login,pass);
    }

    @PostMapping
    public Teacher create(@RequestBody final Teacher teacher){
        return teacherRepository.saveAndFlush(teacher);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        teacherRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher){
        //add validation?
        Teacher existingTeacher = teacherRepository.getReferenceById(id);
        BeanUtils.copyProperties(teacher,existingTeacher,"teacher_id");
        return teacherRepository.saveAndFlush(existingTeacher);
    }
}
