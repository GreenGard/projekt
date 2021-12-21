package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String stad;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "education_id")
    private List<Course> courses = new ArrayList<>();

    public Education() {
    }

    public Education(String name, String stad, List<Course> courses) {
        this.name = name;
        this.stad = stad;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stad='" + stad + '\'' +
                '}';
    }
}