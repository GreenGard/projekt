package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class TeacherDAOImpl implements TeacherDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    Integer infotwo = 0;

    public TeacherDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Teacher teacher) {
        em.getTransaction().begin();
        System.out.println("Enter firstname");
        String name = scanner.nextLine();
        System.out.println("Enter lastname");
        String lastname = scanner.nextLine();
        teacher.setFirstName(name);
        teacher.setLastName(lastname);
        em.persist(teacher);
        em.getTransaction().commit();
    }


    @Override
    public void update(Teacher teacher) {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Ange id för update");
        infotwo = scanner.nextInt();
        System.out.println("Ange nytt namn för update");
        String newName = scanner.next();
        teacher = em.find(Teacher.class, infotwo);
        teacher.setFirstName(newName);
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void findAll() {
        String jql = "SELECT b FROM Teacher as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
    }

    @Override
    public void sortByTeacher() {
        System.out.println("Ange lärare");
        info = scanner.next();
        TypedQuery<Teacher> query = em.createQuery("SELECT s FROM Teacher s WHERE s.firstName LIKE :name", Teacher.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
    }

    @Override
    public void delete(Teacher teacher) {
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id for teacher");
        infotwo = scanner.nextInt();
        teacher = em.find(Teacher.class, infotwo);
        //   List<Course> courses = teacher.getCourses();
        //courses.forEach(course -> em.merge(course));
        em.remove(teacher);
        em.getTransaction().commit();

    }

    public void addCourseToTeacher() {
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id of Teacher");
        int teacherId = scanner.nextInt();
        System.out.println("Enter id of course");
        infotwo = scanner.nextInt();
        Course course = em.find(Course.class, infotwo);
        Teacher teacher = em.find(Teacher.class, teacherId);
         List<Course> courseList = teacher.getCourse();
         courseList.add(course);
         teacher.setCourse(courseList);
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void deleteFromCourse(int teacherId, int courseId) {
    }

    @Override
    public List<Teacher> getByEducation(int educationId) {
        return null;
    }

    public void deleteCourseFromTeacher() {
        em.getTransaction().begin();
        System.out.println("Enter id of Teacher");
        int teacherId = scanner.nextInt();
        Teacher teacher = em.find(Teacher.class, teacherId);
        List<Course> courses = teacher.getCourse();

        System.out.println("Choose id of course you want to remove");
        int count = 0;
        for (Course course : courses) {
            System.out.println(count + " " + course.getNameCourse());
            count++;
        }
        int input = scanner.nextInt();
        courses.remove(input);
        teacher.setCourse(courses);
        em.getTransaction().commit();
    }
}