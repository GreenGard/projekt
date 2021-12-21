package org.example;

public interface CourseDAO {
    public void create(Course course);
    public void update(Course course);
    public void connectToEducation(Course course);
    public void findAll();
    public void  sortByCourse();
    public void delete(Course course);
}