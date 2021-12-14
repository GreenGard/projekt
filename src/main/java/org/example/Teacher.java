package org.example;

import javax.persistence.ManyToMany;
import java.util.List;

public class Teacher {
    private String id;
    private String firstname;
    private String lastname;

    @ManyToMany(targetEntity = Course.class)
    private List<Course> course;

    public Teacher(String enu, String eddie, String nuemann) {
    }


    public Teacher(String id, String firstname, String lastname, List<Course> course) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", course=" + course +
                '}';
    }
}
