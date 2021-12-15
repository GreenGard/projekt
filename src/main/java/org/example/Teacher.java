package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @ManyToMany(targetEntity = Course.class)
    private Set courseSet;

    public Teacher(){
        super();
    }


    public Teacher(String firstname, String lastname,Set courseSet) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.courseSet=courseSet;
    }

    public int getId() {
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

    public Set getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
