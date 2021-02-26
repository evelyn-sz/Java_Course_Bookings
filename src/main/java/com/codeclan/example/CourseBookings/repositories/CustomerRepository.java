package com.codeclan.example.CourseBookings.repositories;

import com.codeclan.example.CourseBookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomersByBookingsCourseId(Long id);
    List<Customer> findAllByTownAndBookingsCourseId(String town, Long courseId);
    List<Customer> findAllByAgeGreaterThanAndTownAndBookingsCourseId(int age, String town, Long courseId);
}
// Get all customers in a given town for a given course
// Get all customers over a certain age in a given town for a given course
// Handle case-sensitive routes "IgnoreCase"
