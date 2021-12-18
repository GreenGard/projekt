package org.example;

import java.util.List;

public interface StudentDAO {
    public void create(Student student);
    public void update(Student student);
    public List<Student> findAll();
    public List<Student>  sortByStudent();
    public void delete(Student student);

}


