package com.codeclan.example.CourseBookings;

import com.codeclan.example.CourseBookings.repositories.BookingRepository;
import com.codeclan.example.CourseBookings.repositories.CourseRepository;
import com.codeclan.example.CourseBookings.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCoursesWithGivenRating(){
		assertEquals(2, courseRepository.findByRating(5).size());
	}

}
