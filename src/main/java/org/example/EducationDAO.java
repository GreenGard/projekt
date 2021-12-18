package org.example;
import java.util.List;

public interface EducationDAO {

        public void create(Education education);
        public void update(Education education);
        public List<Education> findAll();
        public List<Education>  sortByEducation();
        public void delete(Education education);
        public void getCourseByEducation(Education education);

    }
