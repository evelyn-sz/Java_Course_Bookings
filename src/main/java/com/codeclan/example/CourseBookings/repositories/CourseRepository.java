package com.codeclan.example.CourseBookings.repositories;

import com.codeclan.example.CourseBookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
}
