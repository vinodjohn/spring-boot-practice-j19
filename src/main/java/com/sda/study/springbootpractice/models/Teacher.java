package com.sda.study.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Teacher model
 *
 * @author Vinod John
 * @Date 22.02.2023
 */
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> specializedCourses;
}
