package com.codeclan.example.CourseBookings.components;

import com.codeclan.example.CourseBookings.models.Booking;
import com.codeclan.example.CourseBookings.models.Course;
import com.codeclan.example.CourseBookings.models.Customer;
import com.codeclan.example.CourseBookings.repositories.BookingRepository;
import com.codeclan.example.CourseBookings.repositories.CourseRepository;
import com.codeclan.example.CourseBookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){};

    public void run(ApplicationArguments args){
        Course psd = new Course("PSD", "Edinburgh", 5);
        courseRepository.save(psd);

        Course da = new Course("DA", "Inverness", 4);
        courseRepository.save(da);

        Course cs = new Course("CS", "Glasgow", 5);
        courseRepository.save(cs);

        Customer laura = new Customer("Laura", "Budapest", 17);
        customerRepository.save(laura);

        Customer evelyn = new Customer("Evelyn", "Siedlce", 13);
        customerRepository.save(evelyn);

        Customer bob = new Customer("Bob", "Dundee", 21);
        customerRepository.save(bob);

        Customer scot = new Customer("Scot", "Dundee", 25);
        customerRepository.save(scot);

        Booking booking1 = new Booking("25/02/2021", laura, psd);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("25/01/2021", evelyn, da);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("25/03/2021", bob, cs);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("25/04/2021", laura, cs);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("25/04/2021", scot, cs);
        bookingRepository.save(booking5);






    }
}
