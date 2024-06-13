package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Course;
import com.example.demo.Repository.CouseRepository;

@Service
public class CourseService {

    @Autowired

    private CouseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());
        course.setCredits(courseDetails.getCredits());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Custom method to find courses by name
    public List<Course> getCoursesByName(String name) {
        return courseRepository.findByName(name);
    }

    // Custom method to find courses by credits range
    public List<Course> getCoursesByCreditsRange(int minCredits, int maxCredits) {
        return courseRepository.findByCreditsBetween(minCredits, maxCredits);
    }

    // Custom method to find courses whose name starts with a specific prefix
    public List<Course> getCoursesByPrefix(String prefix) {
        return courseRepository.findByPrefix(prefix);
    }
}
