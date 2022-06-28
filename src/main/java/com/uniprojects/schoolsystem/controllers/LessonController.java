package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Lesson;

import com.uniprojects.schoolsystem.repositories.LessonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    public List<Lesson> list(){
        return lessonRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Lesson get(@PathVariable Long id){
        return lessonRepository.getReferenceById(id);
    }


    @PostMapping
    public Lesson create(@RequestBody final Lesson lesson){
        return lessonRepository.saveAndFlush(lesson);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        lessonRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Lesson update(@PathVariable Long id, @RequestBody Lesson lesson){
        //add validation?
        Lesson existingLesson = lessonRepository.getReferenceById(id);
        BeanUtils.copyProperties(lesson,existingLesson,"lesson_id");
        return lessonRepository.saveAndFlush(existingLesson);
    }
}
