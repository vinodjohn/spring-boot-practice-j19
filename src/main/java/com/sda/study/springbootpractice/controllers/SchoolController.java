package com.sda.study.springbootpractice.controllers;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Vinod John
 * @Date 01.03.2023
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public List<School> findAllSchools() {
        return schoolService.findAllSchools();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSchoolById(@PathVariable Long id) throws SchoolNotFoundException {
        School school = schoolService.findSchoolById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());
        return new ResponseEntity<>(school, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Long id) throws CourseNotFoundException, SchoolNotFoundException {
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Called when we press submit button in the create-school form
    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody School school) {
        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            throw new RuntimeException("School already exists! Cannot create this school!");
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSchool(@RequestBody School school) throws SchoolNotFoundException {
        schoolService.updateSchool(school);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreSchool(@PathVariable Long id) throws CourseNotFoundException, SchoolNotFoundException {
        schoolService.restoreSchoolById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
