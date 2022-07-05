package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Assignment;

import com.uniprojects.schoolsystem.repositories.AssignmentRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @GetMapping
    public List<Assignment> list(){
        return assignmentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Assignment get(@PathVariable Long id){
        return assignmentRepository.getReferenceById(id);
    }

    @PostMapping
    public Assignment create(@RequestBody final Assignment assignment){
        return assignmentRepository.saveAndFlush(assignment);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        assignmentRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Assignment update(@PathVariable Long id, @RequestBody Assignment assignment){
        //add validation?
        Assignment existingAssignment = assignmentRepository.getReferenceById(id);
        BeanUtils.copyProperties(assignment,existingAssignment,"assignment_id");
        return assignmentRepository.saveAndFlush(existingAssignment);
    }

}
