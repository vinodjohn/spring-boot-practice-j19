package com.sda.study.springbootpractice.exceptions;

/**
 * Exception for the teacher not found
 *
 * @author Vinod John
 * @Date 27.02.2023
 */
public class TeacherNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher not found for id: %d", id));
    }

    public TeacherNotFoundException(String name) {
        super(String.format("Teacher not found for name: %s", name));
    }
}
