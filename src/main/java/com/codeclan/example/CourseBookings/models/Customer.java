package com.codeclan.example.CourseBookings.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="town")
    private String town;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"customer"})
    private List<Booking> bookings;

//    @ManyToMany
//    @JsonIgnoreProperties({"customers"})
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "customers_courses",
//            joinColumns = { @JoinColumn(
//                    name = "customer_id",
//                    nullable = false,
//                    updatable = false
//            )},
//            inverseJoinColumns = {@JoinColumn(
//                    name = "course_id",
//                    nullable = false,
//                    updatable = false
//            )}
//    )
//    private List<Course> courses;

    public Customer(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
        this.bookings = new ArrayList<>();
//        this.courses = new ArrayList<>();
    }

    public Customer(){};

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
