package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class EducationDAOImpl implements EducationDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    String info2 = " ";
    Integer infotwo = 0;

    public EducationDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Education education) {
        em.getTransaction().begin();
        System.out.println("Enter education name");
        info = scanner.nextLine();
        System.out.println("enter city");
        info2 = scanner.nextLine();
        education.setName(info);
        education.setStad(info2);
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void update(Education education) {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id");
        infotwo = scanner.nextInt();
        System.out.println("Enter education name");
        String newName = scanner.next();
        System.out.println("Enter city");
        String newCity = scanner.next();
        education = em.find(Education.class, infotwo);
        education.setName(newName);
        education.setStad(newCity);
        em.merge(education);
        em.getTransaction().commit();
        //et.commit();
    }

    @Override
    public void findAll() {
        String jql = "SELECT b FROM Education as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
    }


    @Override
    public void sortByEducation() {
        System.out.println("Enter education name");
        info = scanner.next();
        TypedQuery<Education> query = em.createQuery("SELECT s FROM Education s WHERE s.name LIKE :name", Education.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
    }

    @Override
    public void delete(Education education) {
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter id");
        infotwo = scanner.nextInt();
        education = em.find(Education.class, infotwo);
        em.remove(education);
        em.getTransaction().commit();
    }

    public void getCourseByEducation(Education education) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Choose Education by name");
        info = scanner.next();
        String query = String.format("select e, c from  Education as e, Course as c where c.education = e.id and e.name= '%s'", info);
        List<Object[]> results = em.createQuery(query).getResultList();

        for (Object[] tables : results) {
            Education e = (Education) tables[0];
            Course c = (Course) tables[1];
            System.out.println(e.getName() + " " + c.getNameCourse());
        }
    }

    public void getAllStudentsByEducation() {
        EntityManager em = emf.createEntityManager();
        System.out.println("Choose Education by name");
        info = scanner.next();
        String query = String.format("select e, s from Education as e, Student as s where s.education = e.id and e.name = '%s'", info);
        List<Object[]> results = em.createQuery(query).getResultList();

        for (Object[] tables : results) {
            Education e = (Education) tables[0];
            Student s = (Student) tables[1];
            System.out.println(e.getName() + " " + s.getFirstname() + " " + s.getLastname());
        }
    }

    public void popularEducation() {
        EntityManager em = emf.createEntityManager();
        String query = "SELECT e, count(s.id) as amount_of_students from Education as e left join Student as s on s.education = e group by e order by amount_of_students desc ";
        List<Object[]> results = em.createQuery(query).getResultList();

        for (Object[] tables : results) {
            System.out.println(" Amount of Students " + tables[1] + " " + tables[0].toString());
        }
    }
}