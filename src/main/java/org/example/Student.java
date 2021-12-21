package org.example;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String stad;
    private String born;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Education education;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, String stad, String born, Education education) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.stad = stad;
        this.born = born;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public void setId(int id) {
        this.id = id;
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
                ", born=" + born +
                ", education=" + education +
                '}';
    }
}