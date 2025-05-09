package com.cts.crm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path; // New field for request URI
}
