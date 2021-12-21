package org.example;

import javax.persistence.*;
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

    @ManyToMany(targetEntity =Course.class,cascade = CascadeType.REMOVE)
    private List course;

    public Education() {
    }

    public Education(String name, String stad, List course) {
        this.name = name;
        this.stad = stad;
        this.course = course;
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

    public List getCourse() {
        return course;
    }

    public void setCourse(List course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stad='" + stad + '\'' +
                ", course=" + course +
                '}';
    }
}