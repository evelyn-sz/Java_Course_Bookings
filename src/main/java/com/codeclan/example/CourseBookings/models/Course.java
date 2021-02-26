package com.codeclan.example.CourseBookings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="town")
    private String town;

    @Column(name="rating")
    private int rating;

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"course"})
//    @JoinColumn(name="booking_id", nullable = false)
    private List<Booking> bookings;

//    @ManyToMany
//    @JsonIgnoreProperties({"courses"})
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "customers_courses",
//            joinColumns = {@JoinColumn(
//                    name = "course_id",
//                    nullable = false,
//                    updatable = false
//            )},
//            inverseJoinColumns = {@JoinColumn(
//                    name = "customer_id",
//                    nullable = false,
//                    updatable = false
//            )}
//    )
//    private List<Customer> customers;

    public Course( String name, String town, int rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.bookings = new ArrayList<>();
//        this.customers = new ArrayList<>();
    }

    public Course(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
