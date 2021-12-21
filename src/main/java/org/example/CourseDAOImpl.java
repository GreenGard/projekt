package org.example;

import javax.persistence.*;
import java.util.Scanner;

public class CourseDAOImpl implements CourseDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    Integer infotwo = 0;

    public CourseDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Course course) {
        em.getTransaction().begin();
        System.out.println("Enter new course");
        info = scanner.nextLine();
        course.setNameCourse(info);
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter course id for update");
        infotwo = scanner.nextInt();
        System.out.println("Update name for course-no whitespace");
        String newName = scanner.next();
        System.out.println("Update Education by id to Course");
        int newEducation = scanner.nextInt();
        course = em.find(Course.class, infotwo);
        Education education = em.find(Education.class, newEducation);
        education.getCourse().add(course);
        course.setNameCourse(newName);
        em.merge(course);
        em.merge(education);
        em.getTransaction().commit();
    }

    @Override
    public void connectToEducation(Course course) {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id to connect to education");
        infotwo = scanner.nextInt();
        String newName = scanner.next();
        course = em.find(Course.class, infotwo);
        course.setNameCourse(newName);
        et.commit();
    }

    @Override
    public void findAll() {
        String jql = "SELECT b FROM Course as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
    }

    @Override
    public void sortByCourse() {
        System.out.println("Enter course");
        info = scanner.next();
        TypedQuery<Course> query = em.createQuery("SELECT s FROM Course s WHERE s.nameCourse LIKE :name", Course.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
    }

    @Override
    public void delete(Course course) {
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id to delete");
        infotwo = scanner.nextInt();
        course = em.find(Course.class, infotwo);
        em.remove(course);
        em.getTransaction().commit();
    }
}