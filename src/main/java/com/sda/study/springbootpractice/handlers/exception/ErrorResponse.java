package com.sda.study.springbootpractice.handlers.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for Error Response
 *
 * @author Vinod John
 * @Date 08.03.2023
 */

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
