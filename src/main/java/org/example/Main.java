package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Education education1=new Education("Javautvecklare");
        Education education2=new Education(".Net-utvecklare");
        em.persist(education1);
        em.persist(education2);

        Course course1=new Course("Javaprogrammering",education1,null);
        Course course2=new Course("Utveckling mot databaser",education1,null);
        Course course3=new Course("Programmering C#",education2,null);
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);

        Set<Course> courseSet1 = new HashSet();
        courseSet1.add(course1);
        courseSet1.add(course2);

        Set<Course> courseSet2 = new HashSet();
        courseSet2.add(course3);


        Teacher teacher1=new Teacher("Martin","Blomberg",courseSet1);
        Teacher teacher2=new Teacher("Eddie","Neumann",courseSet1);
        Teacher teacher3=new Teacher("Johnny","Blue",courseSet2);
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(teacher3);
                Student student1=new Student("Madelene","Axblom","madelene.axblom@iths.se","Göteborg",education1);

    em.persist(student1);


    em.getTransaction().commit();
    em.close();
    }
}
