package com.sda.study.springbootpractice.models;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * User model
 *
 * @author Vinod John
 * @Date 14.03.2023
 */
@Data
public class User {
    private String firstName;
    private String lastName;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
