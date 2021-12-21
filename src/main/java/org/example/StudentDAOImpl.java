package org.example;

import javax.persistence.*;
import java.util.Scanner;

public class StudentDAOImpl implements StudentDAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    Scanner scanner = new Scanner(System.in);

    String info = " ";
    Integer infotwo = 0;

    public StudentDAOImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Student student) {
        em.getTransaction().begin();
        System.out.println("Enter your firstname");
        String name = scanner.nextLine();
        System.out.println("Enter your lastname");
        String lastname = scanner.nextLine();
        System.out.println("Enter your emailadress");
        String email = scanner.nextLine();
        System.out.println("Enter your city");
        String city = scanner.nextLine();
        System.out.println("Enter your birthdate in format XXXX-XX-XX");
        String born = scanner.nextLine();
        System.out.println("Enter id of education to be connected to");
        infotwo = scanner.nextInt();
        Education education = em.find(Education.class, infotwo);
        student.setFirstname(name);
        student.setLastname(lastname);
        student.setEmail(email);
        student.setStad(city);
        student.setBorn(born);
        student.setEducation(education);
        em.persist(student);
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        System.out.println("Enter Student id for update");
        infotwo = scanner.nextInt();
        System.out.println("Update name");
        String newName = scanner.next();
        System.out.println("Update lastname");
        String newLastName = scanner.next();
        System.out.println("Update email");
        String newemail = scanner.next();
        System.out.println("Update city");
        String newCity = scanner.next();
        System.out.println("Update born");
        String newBorn = scanner.next();
        System.out.println("Update Education by id to Course");
        int newEducation = scanner.nextInt();
        Education education = em.find(Education.class, newEducation);
        student = em.find(Student.class, infotwo);
        student.setFirstname(newName);
        student.setLastname(newLastName);
        student.setEmail(newemail);
        student.setStad(newCity);
        student.setBorn(newBorn);
        student.setEducation(education);
        em.merge(education);
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void findAll() {
        String jql = "SELECT b FROM Student as b order by b.id";
        Query query = em.createQuery(jql);
        System.out.println(query.getResultList());
    }

    @Override
    public void sortByStudent() {
        System.out.println("Enter Student");
        info = scanner.next();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.firstname LIKE :name", Student.class);
        query.setParameter("name", "%" + info + "%");
        System.out.println(query.getResultList());
    }

    @Override
    public void delete(Student student) {
        em.getTransaction();
        et.begin();
        System.out.println("Enter Student id for delete");
        infotwo = scanner.nextInt();
        student = em.find(Student.class, infotwo);
        em.remove(student);
        em.getTransaction().commit();
    }
}