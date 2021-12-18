package org.example;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        String choice = " ";
        do {
            System.out.println("Menu options: ");
            System.out.println("A: Education");
            System.out.println("B: Course");
            System.out.println("C: Student");
            System.out.println("D: Teacher");
            System.out.println("q: Quit");
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    educationmenu();
                    break;
                case "B":
                    coursemenu();
                    break;
                case "C":
                    studentmenu();
                    break;
                case "D":
                    //teachermenu();
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
                    break;
            }
        } while (!choice.equals("Q"));
    }

    private static void educationmenu() {
        String choice = " ";
        Education education = new Education();
        EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
        do {
            System.out.println("1: Add Education");
            System.out.println("2: Update Education");
            System.out.println("3: Show by Education");
            System.out.println("4: Show all info for Educations");
            System.out.println("5: Delete Education");
            System.out.println("6: List all courser per Education");
            System.out.println("q: Go back to startmenu");
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    educationDAOImpl.create(education);
                    break;
                case "2":
                    educationDAOImpl.update(education);
                    break;
                case "3":
                    educationDAOImpl.sortByEducation();
                    break;
                case "4":
                    educationDAOImpl.findAll();
                    break;
                case "5":
                    educationDAOImpl.delete(education);
                    break;
                case "6":
                    educationDAOImpl.getCourseByEducation(education);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }


    private static void coursemenu() {
        String choice = " ";
        Course course = new Course();
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl();
        do {
            System.out.println("7: Add Course");
            //System.out.println("7: Add Course to Education");
            System.out.println("8: Update Course");
            System.out.println("9: Show all Courses");
            //  System.out.println("10: Show all Courses By Education");
            System.out.println("11: Show by Courses");
            System.out.println("12: Delete Course");
            //System.out.println("13: Remove Course from Education");
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "7":
                    courseDAOImpl.create(course);
                    break;
                case "8":
                    courseDAOImpl.update(course);
                    break;
                case "9":
                    courseDAOImpl.findAll();
                    break;
                case "11":
                    courseDAOImpl.sortByCourse();
                    break;
                case "12":
                    courseDAOImpl.delete(course);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }


    private static void studentmenu() {
        String choice = " ";
        Student student = new Student();
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
        do {
            System.out.println("14: Register Student");
            System.out.println("15: Update Student info");
            System.out.println("16: View Student info");
            System.out.println("17: View all Student info");
            //System.out.println("18: Add Student to Education");
            // System.out.println("19: Remove Student from Education");
            //System.out.println("20: View all Student by Education");
            System.out.println("21: Delete Student");
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "14":
                    studentDAOImpl.create(student);
                    break;
                case "15":
                    studentDAOImpl.update(student);
                    break;
                case "16":
                    studentDAOImpl.findAll();
                    break;
                case "17":
                    studentDAOImpl.sortByStudent();
                    break;
                case "21":
                    studentDAOImpl.delete(student);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }
}

        /*
    private static void teachermenu() {
        System.out.println("14: Register Student");
        System.out.println("15: Update Student info");
        System.out.println("16: View Student info");
        System.out.println("17: View all Student info");
        System.out.println("18: Add Student to Education");
        System.out.println("19: Remove Student from Education");
        System.out.println("20: View all Student by Education");
        System.out.println("21: Delete Student");


*/