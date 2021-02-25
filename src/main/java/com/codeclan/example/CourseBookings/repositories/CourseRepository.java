package com.codeclan.example.CourseBookings.repositories;

import com.codeclan.example.CourseBookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
