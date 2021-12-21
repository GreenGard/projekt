package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
         Menu.menu();

/*
        em.getTransaction().begin();

        Education education1 = new Education("Javautvecklare", "Göteborg",null);
        Education education2 = new Education(".Net-utvecklare", "Göteborg",null);
        Education education3 = new Education("Mjukvarutestare", "Göteborg",null);
        Education education4 = new Education("Webbutvecklare", "Göteborg",null);
        Education education5 = new Education("Apputvecklare", "Stockholm",null);
        Education education6 = new Education("Frontendutvecklare", "Göteborg",null);
        Education education7 = new Education("IT-projektledare", "Stockholm",null);
        Education education8 = new Education("JavaScriptutvecklare", "Göteborg",null);
        em.persist(education1);
        em.persist(education2);
        em.persist(education3);
        em.persist(education4);
        em.persist(education5);
        em.persist(education6);
        em.persist(education7);
        em.persist(education8);

        Course course1 = new Course("Javaprogrammering", education1);
        Course course2 = new Course("Utveckling mot databaser", education1);
        Course course3 = new Course("Programmering C#", education2);
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);

        ArrayList<Teacher> arr1 = new ArrayList<Teacher>();
        ArrayList<Teacher> arr2 = new ArrayList<Teacher>();
        ArrayList<Teacher> arr3 = new ArrayList<Teacher>();
        ArrayList<Teacher> arr4 = new ArrayList<Teacher>();


        Teacher teacher1 = new Teacher("Martin", "Blomberg",arr1 );
        Teacher teacher2 = new Teacher("Eddie", "Neumann",arr1);
        Teacher teacher3 = new Teacher("Johnny", "Blue",arr2);
        Teacher teacher4 = new Teacher("Anna", "Andersson",arr3);
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(teacher3);
        em.persist(teacher4);
//course id 1
        arr1.add(teacher1);
        arr1.add(teacher3);

//course id 2
        arr2.add(teacher2);
//course id 3
        arr3.add(teacher1);


        Student student1 = new Student("Madelene", "Axblom", "madelene.axblom@iths.se", "Göteborg", "1985-11-25",education1);
        Student student2 = new Student("Hans", "Gretchen", "hans.gretchen@iths.se", "Göteborg", "1984-11-25",education2);
        Student student3 = new Student("Anna", "Nilsson", "anna.nilsson@iths.se", "Göteborg", "1990-08-01",education1);
        Student student4 = new Student("Erik", "Larsson", "erik.larsson@iths.se", "Göteborg", "2000-01-01",education3);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);




        em.getTransaction().commit();


*/

        em.close();
    }
}