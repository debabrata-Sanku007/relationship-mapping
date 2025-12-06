package com.mapping.onetomany.service;


import com.mapping.onetomany.entity.Course;
import com.mapping.onetomany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public Optional<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }
}
