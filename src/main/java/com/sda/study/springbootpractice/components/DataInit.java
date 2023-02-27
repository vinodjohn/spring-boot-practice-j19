package com.sda.study.springbootpractice.components;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Component to initialize data on application startup
 *
 * @author Vinod John
 * @Date 27.02.2023
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;

    @PostConstruct
    public void init() {
        initSchool();
    }

    // PRIVATE METHODS //
    private void initSchool() {
        System.out.println("Starting School initialization...");
        School school = new School();
        school.setName("Tartu University");
        school.setAddress("Ulikooli 18, Tartu.");
        school.setPhone("+372589632147");

        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Cannot pre-initialize school: " + school.getName());
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }
}
