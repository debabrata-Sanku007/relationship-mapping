package com.mapping.onetomany.controller;


import com.mapping.onetomany.entity.Course;
import com.mapping.onetomany.entity.Student;
import com.mapping.onetomany.service.CourseService;
import com.mapping.onetomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/onetomany")
public class OneToManyController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.savedStudent(student);
        if (savedStudent == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{ans_id}")
    public ResponseEntity<Course> getCourse(@PathVariable("ans_id") int id) {
        Optional<Course> course = courseService.getCourse(id);
        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<Student> getQuestion(@RequestParam(name = "q_id") int id) {
        Optional<Student> question = studentService.getQuestion(id);
        if (question.isPresent()) {
            return new ResponseEntity<>(question.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
