package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nameCourse;

    @ManyToOne(cascade = CascadeType.REMOVE)

    @JoinColumn(name ="education_id")
    private Education education;


    public Course() {

    }

    public Course( String nameCourse, Education education) {

        this.nameCourse = nameCourse;
        this.education = education;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                ", education=" + education +
                '}';
    }
}


