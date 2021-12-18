package org.example;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class EducationDAOImpl implements EducationDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    Integer infotwo = 0;
    Integer infothree = 0;

    public EducationDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }


    @Override
    public void create(Education education) {
        em.getTransaction().begin();
        System.out.println("Skriv in ny utbildning");
        info = scanner.nextLine();
        education.setName(info);
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void update(Education education) {

        try {
            emf = Persistence.createEntityManagerFactory("jpa");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för update");
            infotwo = scanner.nextInt();
            System.out.println("Ange nytt namn för update");
            String newName = scanner.next();
            education = em.find(Education.class, infotwo);
            education.setName(newName);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public List<Education> findAll() {
        String jql = "SELECT b FROM Education as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
        return null;
    }


    @Override
    public List<Education> sortByEducation() {
        System.out.println("Ange utbildning");
        info = scanner.next();
        TypedQuery<Education> query = em.createQuery("SELECT s FROM Education s WHERE s.name LIKE :name", Education.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
        return null;
    }

    @Override
    public void delete(Education education) {

        try {
            et = em.getTransaction();
            et.begin();
            System.out.println("Ange id för delete");
            infotwo = scanner.nextInt();
            education = em.find(Education.class, infotwo);
            em.remove(education);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
            emf.close();


        }
    }

    public void getCourseByEducation(Education education) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Ange utbildning");
        info = scanner.next();
        String query =
                String.format("select e, c from  Education as e, Course as c where  e.name='%s' and c.nameCourse = c.nameCourse", info);
        List<Object[]> results = em.createQuery(query).getResultList();

        for (Object[] tables : results) {
            Education e = (Education) tables[0];
            Course c = (Course) tables[1];
            System.out.println(e.getName() + " " + c.getNameCourse());
        }
    }
}

