package com.mapping.onetomany.service;


import com.mapping.onetomany.entity.Student;
import com.mapping.onetomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student savedStudent(Student student) {
        return studentRepository.save(student);

    }

    public Optional<Student> getQuestion(int id) {
        return studentRepository.findById(id);
    }
}
