package com.iiitb.academic.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentID;

    @Column(name = "roll_number",nullable = false,unique = true)
    private String rollNumber;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,columnDefinition = "float default 0.0")
    private float cgpa;

    @Column(name = "total_credits",nullable = false)
    private String totalCredits;

    @Column(name = "graduation_year",nullable = false)
    private String graduationYear;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToMany (fetch = FetchType.EAGER, targetEntity = Course.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Student_Courses",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Course> courseList;





}
