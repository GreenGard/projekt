package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class CourseDAOImpl implements CourseDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    String infosecond = " ";
    Integer infotwo = 0;
    Integer infothree = 0;

    public CourseDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    /////////////////lägg till fler val att lägga till
    @Override
    public void create(Course course) {
        em.getTransaction().begin();
        System.out.println("Skriv in ny kurs");
        info = scanner.nextLine();
        System.out.println("Skriv in id för Education");
        infotwo = scanner.nextInt();
        course.setNameCourse(info);
        course.setEducation(course.getEducation());
        em.persist(course);
        em.getTransaction().commit();
    }


    @Override
    public void update(Course course) {
        try {
            emf = Persistence.createEntityManagerFactory("jpa");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för update");
            infotwo = scanner.nextInt();
            System.out.println("Ange nytt namn för update");
            String newName = scanner.next();
            course = em.find(Course.class, infotwo);
            course.setNameCourse(newName);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public void connectToEducation(Course course) {
        try {
            emf = Persistence.createEntityManagerFactory("jpa");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id att koppla till utbildning");
            infotwo = scanner.nextInt();

            String newName = scanner.next();
            course = em.find(Course.class, infotwo);
            course.setNameCourse(newName);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public List<Course> findAll() {
        String jql = "SELECT b FROM Course as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
        return null;
    }

    @Override
    public List<Course> sortByCourse() {
        System.out.println("Ange kurs");
        info = scanner.next();
        TypedQuery<Course> query = em.createQuery("SELECT s FROM Course s WHERE s.nameCourse LIKE :name", Course.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
        return null;
    }

    @Override
    public void delete(Course course) {
        try {
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för delete");
            infotwo = scanner.nextInt();
            course = em.find(Course.class, infotwo);
            em.remove(course);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();

        }
    }
}
