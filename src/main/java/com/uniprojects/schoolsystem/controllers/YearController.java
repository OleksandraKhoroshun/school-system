package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Year;

import com.uniprojects.schoolsystem.repositories.YearRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/years")
public class YearController {
    @Autowired
    private YearRepository yearRepository;

    @GetMapping
    public List<Year> list(){
        return yearRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Year get(@PathVariable Long id){
        return yearRepository.getReferenceById(id);
    }

    @PostMapping
    public Year create(@RequestBody final Year year){
        return yearRepository.saveAndFlush(year);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        yearRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Year update(@PathVariable Long id, @RequestBody Year year){
        //add validation?
        Year existingYear= yearRepository.getReferenceById(id);
        BeanUtils.copyProperties(year,existingYear,"year_id");
        return yearRepository.saveAndFlush(existingYear);
    }
}
