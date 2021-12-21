package org.example;

public interface EducationDAO {
    public void create(Education education);
    public void update(Education education);
    public void findAll();
    public void sortByEducation();
    public void delete(Education education);

}