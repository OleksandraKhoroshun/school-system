package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.LessonYear;

import com.uniprojects.schoolsystem.repositories.LessonYearRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons_years")
public class LessonYearController {

    @Autowired
    private LessonYearRepository lessonYearRepository;

    @GetMapping
    public List<LessonYear> list(){
        return lessonYearRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public LessonYear get(@PathVariable Long id){
        return lessonYearRepository.getReferenceById(id);
    }

    @PostMapping
    public LessonYear create(@RequestBody final LessonYear lessonYear){
        return lessonYearRepository.saveAndFlush(lessonYear);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        lessonYearRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public LessonYear update(@PathVariable Long id, @RequestBody LessonYear lessonYear){
        //add validation?
        LessonYear existingLessonYear = lessonYearRepository.getReferenceById(id);
        BeanUtils.copyProperties(lessonYear,existingLessonYear,"lesson_Year_id");
        return lessonYearRepository.saveAndFlush(existingLessonYear);
    }
}
