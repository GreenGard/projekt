package org.example;

public interface StudentDAO {
    public void create(Student student);
    public void update(Student student);
    public void findAll();
    public void sortByStudent();
    public void delete(Student student);
}