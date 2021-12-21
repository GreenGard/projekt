package org.example;

import java.util.List;

public interface TeacherDAO {
    public void create(Teacher teacher);
    public void update(Teacher teacher);
    public void findAll();
    public void  sortByTeacher();
    public void delete(Teacher teacher);
    public void addCourseToTeacher();
    void deleteFromCourse(int teacherId, int courseId);

    List<Teacher> getByEducation(int educationId);
}
