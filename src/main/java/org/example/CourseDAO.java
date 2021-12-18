package org.example;

import java.util.List;

public interface CourseDAO {
    public void create(Course course);
    public void update(Course course);
    public void connectToEducation(Course course);
    public List<Course> findAll();
    public List<Course>  sortByCourse();
    public void delete(Course course);

}



