package org.example;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCourse;
    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    public Education getEducation() {
        return education;
    }

    public Course() {
    }

    public Course(String nameCourse, Education education) {
        this.nameCourse = nameCourse;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}


