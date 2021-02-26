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

	@Test
	public void canFindBookingByDate(){
		assertEquals(1, bookingRepository.findByDate("25/03/2021").size());
	}

	@Test
	public void canFindAllCustomersForGivenCourse(){
		assertEquals(1, customerRepository.findAllCustomersByBookingsCourseId(1L).size());
		assertEquals(3, customerRepository.findAllCustomersByBookingsCourseId(3L).size());
	}

	@Test
	public void canFindAllCoursesForGivenCustomer(){
		assertEquals(1, courseRepository.findAllByBookingsCustomerId(2L).size());
		assertEquals(2, courseRepository.findAllByBookingsCustomerId(1L).size());
	}

	@Test
	public void canFindAllCustomersInGivenTownForGivenCourse(){
		assertEquals(2, customerRepository.findAllByTownAndBookingsCourseId("Dundee", 3L).size());
	}

	@Test
	public void canFindAllCustomersOverCertainAgeANDFromGivenTownANDForGivenCourse(){
		assertEquals(1, customerRepository.findAllByAgeGreaterThanAndTownAndBookingsCourseId(23, "Dundee", 3L).size());
		assertEquals(2, customerRepository.findAllByAgeGreaterThanAndTownAndBookingsCourseId(20, "Dundee", 3L).size());
	}
}
// Get all customers in a given town for a given course
// Get all customers over a certain age in a given town for a given course
// Handle case-sensitive routes "IgnoreCase"

