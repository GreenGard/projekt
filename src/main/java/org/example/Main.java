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
        Course course1 = new Course("Javaprogrammering");
        Course course2 = new Course("Utveckling mot databaser");
        Course course3 = new Course("Programmering C#");
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);

//Education och education_course  utbildningarnas kurser
        ArrayList<Course> educationcourses1 = new ArrayList<Course>();
        ArrayList<Course> educationcourses2 = new ArrayList<Course>();
        ArrayList<Course> educationcourses3 = new ArrayList<Course>();
        ArrayList<Course> educationcourses4 = new ArrayList<Course>();

        // här skapas utbildningar och innehåller kurserna
        Education education1 = new Education("Javautvecklare", "Göteborg", educationcourses1);
        Education education2 = new Education(".Net-utvecklare", "Göteborg", educationcourses2);
        Education education3 = new Education("Mjukvarutestare", "Göteborg", educationcourses3);
        Education education4 = new Education("Webbutvecklare", "Göteborg", educationcourses3);
        Education education5 = new Education("Apputvecklare", "Stockholm", educationcourses4);
        Education education6 = new Education("Frontendutvecklare", "Göteborg", educationcourses3);
        Education education7 = new Education("IT-projektledare", "Stockholm", educationcourses3);
        Education education8 = new Education("JavaScriptutvecklare", "Göteborg", educationcourses3);
        em.persist(education1);
        em.persist(education2);
        em.persist(education3);
        em.persist(education4);
        em.persist(education5);
        em.persist(education6);
        em.persist(education7);
        em.persist(education8);

//KURSSAMLING 1
        educationcourses1.add(course1);//javaprogrammering
        educationcourses1.add(course2);//databasutveckling

//KURSSAMLING 2
        educationcourses2.add(course3);//Programmering C#

//KURSSAMLING 3
        educationcourses3.add(course2);//databasutveckling
//KURSSAMLING 4 ....
        educationcourses4.add(course2); //databasutveckling

        ArrayList<Course> teachercourses1 = new ArrayList<Course>();
        ArrayList<Course> teachercourses2 = new ArrayList<Course>();
        ArrayList<Course> teachercourses3 = new ArrayList<Course>();
        ArrayList<Course> teachercourses4 = new ArrayList<Course>();


        Teacher teacher1 = new Teacher("Martin", "Blomberg", teachercourses1);
        Teacher teacher2 = new Teacher("Eddie", "Neumann", teachercourses2);
        Teacher teacher3 = new Teacher("Johnny", "Blue", teachercourses3);
        Teacher teacher4 = new Teacher("Anna", "Andersson", teachercourses4);
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(teacher3);
        em.persist(teacher4);

        //teacher 1
        teachercourses1.add(course1);
        teachercourses1.add(course3);
        //teacher 2
        teachercourses2.add(course2);
        //teacher 3
        teachercourses3.add(course2);
        //teacher 4


        Student student1 = new Student("Madelene", "Axblom", "madelene.axblom@iths.se", "Göteborg", "1985-11-25", education1);
        Student student2 = new Student("Hans", "Gretchen", "hans.gretchen@iths.se", "Göteborg", "1984-11-25", education2);
        Student student3 = new Student("Anna", "Nilsson", "anna.nilsson@iths.se", "Göteborg", "1990-08-01", education1);
        Student student4 = new Student("Erik", "Larsson", "erik.larsson@iths.se", "Göteborg", "2000-01-01", education3);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);

        em.getTransaction().commit();

*/
        em.close();
    }
}