package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Course;

public interface CouseRepository extends JpaRepository<Course, Long> {
    // Find courses by name
    List<Course> findByName(String name);

    // Find courses by credits
    List<Course> findByCreditsBetween(int minCredits, int maxCredits);

    // Find courses whose name stars with a specific prefix
    @Query("SELECT c FROM Course c WHERE c.name LIKE ?1%")
    List<Course> findByPrefix(String prefix);

}
