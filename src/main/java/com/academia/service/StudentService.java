package com.academia.service;

import com.academia.model.Student;
import com.academia.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }
}
