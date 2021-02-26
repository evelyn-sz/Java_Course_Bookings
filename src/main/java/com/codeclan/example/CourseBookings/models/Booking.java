package com.codeclan.example.CourseBookings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name="course_id", nullable = false)
    private Course course;

    public Booking(String date, Customer customer, Course course) {
        this.date = date;
        this.customer = customer;
        this.course = course;
    }

    public Booking(){};

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
