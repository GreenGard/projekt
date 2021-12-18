package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class StudentDAOImpl implements StudentDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    Integer infotwo = 0;
    Integer infothree = 0;

    public StudentDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Student student) {
        em.getTransaction().begin();
        System.out.println("Skriv in ny utbildning");
        info = scanner.nextLine();
        student.setFirstname(info);
        em.persist(student);
        em.getTransaction().commit();


    }

    @Override
    public void update(Student student) {
        try {
            emf = Persistence.createEntityManagerFactory("jpa");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för update");
            infotwo = scanner.nextInt();
            System.out.println("Ange nytt namn för update");
            String newName = scanner.next();
            student = em.find(Student.class, infotwo);
            student.setFirstname(newName);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }


    @Override
    public List<Student> findAll() {
        String jql = "SELECT b FROM Student as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
        return null;
    }

    @Override
    public List<Student> sortByStudent() {
        System.out.println("Ange student");
        info = scanner.next();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.firstname LIKE :name", Student.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
        return null;
    }

    @Override
    public void delete(Student student) {
        try {
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för delete");
            infotwo = scanner.nextInt();
            student = em.find(Student.class, infotwo);
            em.remove(student);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();


        }
    }
}
