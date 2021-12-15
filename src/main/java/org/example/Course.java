package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCourse;
    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToMany(targetEntity = Teacher.class)
    private Set teacherSet;


    public Course() {
        super();
    }

    public Course(String nameCourse, Education education, Set teacherSet) {
        this.nameCourse = nameCourse;
        this.education = education;
        this.teacherSet = teacherSet;
    }

    public Education getEducation() {
        return education;
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

    public void setEducation(Education education) {
        this.education = education;
    }

    public Set getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set teacherSet) {
        this.teacherSet = teacherSet;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}


