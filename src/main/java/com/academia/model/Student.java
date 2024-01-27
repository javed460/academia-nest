package com.academia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private Integer id;
    private String studentName;
    private String studentClass;
    private String dob;
}
