package com.yaromich.spring.services;

import com.yaromich.spring.entities.Course;
import com.yaromich.spring.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    private CoursesRepository coursesRepository;

    @Autowired
    public void setCoursesRepository(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Course> getAllCoursesList() {
        return (List<Course>) coursesRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = coursesRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        }
        return null;
    }
}
