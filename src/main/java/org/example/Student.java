package org.example;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String stad;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "education_id")
    private Education education;
//foregn key till education o sedan kunna ta ut elever i en klass
    public Student() {
    }

    public Student(String firstname, String lastname, String email, String stad, Education education) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.stad = stad;
        this.education = education;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Education getEducation() {
        return education;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", stad='" + stad + '\'' +
                ", education=" + education +
                '}';
    }
}