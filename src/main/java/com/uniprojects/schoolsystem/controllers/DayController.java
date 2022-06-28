package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Day;
import com.uniprojects.schoolsystem.repositories.DayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/days")
public class DayController {
    @Autowired
    private DayRepository dayRepository;

    @GetMapping
    public List<Day> list(){
        return dayRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Day get(@PathVariable Long id){
        return dayRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping("{day_name}")
    public Day get(@PathVariable("day_name") String day_name){
        return dayRepository.findByDay_name(day_name);
    }

    @PostMapping
    public Day create(@RequestBody final Day day){
        return dayRepository.saveAndFlush(day);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        dayRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Day update(@PathVariable Long id, @RequestBody Day day){
        //add validation?
        Day existingDay = dayRepository.getReferenceById(id);
        BeanUtils.copyProperties(day,existingDay,"day_id");
        return dayRepository.saveAndFlush(existingDay);
    }

}
