package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

    //    Teacher// teacher1=new Teacher("MBL","Martin","Blomberg");
    //    Teacher// teacher2=new Teacher("ENE","Eddie","Neumann");

        Education education1=new Education("Javautvecklare");
        Education education2=new Education(".Net-utvecklare");

        Course course1=new Course("Javaprogrammering",education1);
        Course course2=new Course("Utveckling mot databaser",education1);
        Course course3=new Course("Programmering C#",education2);

      //  Student student=new Student("MAX","Madelene","Axblom","madelene.axblom@iths.se","Göteborg",)
    em.getTransaction().begin();
    em.persist(education1);
    em.persist(education2);
    em.persist(course1);
    em.persist(course2);
    em.persist(course3);
    em.getTransaction().commit();
    em.close();
    }
}
