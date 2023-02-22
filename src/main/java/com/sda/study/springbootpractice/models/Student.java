package com.sda.study.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Student model
 *
 * @author Vinod John
 * @Date 22.02.2023
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private float grade;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;
}
