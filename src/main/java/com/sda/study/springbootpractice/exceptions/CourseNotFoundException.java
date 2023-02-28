package com.sda.study.springbootpractice.exceptions;

/**
 * Exception for the course not found
 *
 * @author Vinod John
 * @Date 28.02.2023
 */
public class CourseNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(Long id) {
        super(String.format("Course not found for id: %d", id));
    }

    public CourseNotFoundException(String name) {
        super(String.format("Course not found for name: %s", name));
    }
}
