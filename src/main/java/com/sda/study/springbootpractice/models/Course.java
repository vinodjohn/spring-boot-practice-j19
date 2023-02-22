package com.sda.study.springbootpractice.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Course model
 *
 * @author Vinod John
 * @Date 22.02.2023
 */
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private int durationInDays;

    @OneToOne(cascade = CascadeType.MERGE)
    private School school;
}
