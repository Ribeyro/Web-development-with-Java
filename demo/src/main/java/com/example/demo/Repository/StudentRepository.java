package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Find students by name
    List<Student> findByName(String name);

    // Find students by age
    List<Student> findByAgeBetween(int minAge, int maxAge);

    // Find students whose name stars with a specific prefix
    @Query("SELECT s FROM Student s WHERE s.name LIKE ?1%")
    List<Student> findByPrefix(String prefix);

}
