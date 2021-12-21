package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(length = 45)
    private String firstName;
    @Column(length = 45)
    private String lastName;

    @ManyToMany(targetEntity = Course.class,cascade = CascadeType.REMOVE)
    private List course;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, List course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public List getCourse() {
        return course;
    }

    public void setCourse(List course) {
        this.course = course;
    }

    public void clearList(List<Course> list) {
        list.clear();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}