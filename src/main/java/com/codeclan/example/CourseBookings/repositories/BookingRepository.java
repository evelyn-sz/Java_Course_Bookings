package com.codeclan.example.CourseBookings.repositories;

import com.codeclan.example.CourseBookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
