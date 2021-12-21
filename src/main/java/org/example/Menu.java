package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        String choice = "";
        do {
            System.out.println("Menu options:" +
                    "\n1: Education"+
                    "\n2: Course"+
                    "\n3: Student"+
                    "\n4: Teacher" +
                    "\nq: Quit");
            choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    educationMenu();
                    break;
                case "2":
                    courseMenu();
                    break;
                case "3":
                    studentMenu();
                    break;
                case "4":
                    teacherMenu();
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
                    break;
            }
        } while (!choice.equals("Q"));
    }

    private static void educationMenu() {
        String choice = "";
        Education education = new Education();
        EducationDAOImpl educationDAOImpl = new EducationDAOImpl();

        do {
            System.out.println("1: Add Education" +
                    "\n2: Update Education" +
                    "\n3: Sort by Education" +
                    "\n4: Show all" +
                    "\n5: Delete Education" +
                    "\n6: List all students in selected Education" +
                    "\n7: Education statistics" +
                    "\nq: Go back to startMenu");
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
                    educationDAOImpl.getAllStudentsByEducation();
                    break;
                case "7":
                    educationDAOImpl.popularEducation();
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }


    private static void courseMenu() {
        String choice = " ";
        Course course = new Course();
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl();

        do {
            System.out.println("1: Add Course" +
                    "\n2: Update Course" +
                    "\n3: Show all" +
                    "\n4: Show by Course" +
                    "\n5: Delete Course" +
                    "\nq: Go back to startMenu");

            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    courseDAOImpl.create(course);
                    break;
                case "2":
                    courseDAOImpl.update(course);
                    break;
                case "3":
                    courseDAOImpl.findAll();
                    break;
                case "4":
                    courseDAOImpl.sortByCourse();
                    break;
                case "5":
                    courseDAOImpl.delete(course);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }


    private static void studentMenu() {
        String choice = " ";
        Student student = new Student();
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
        do {
            System.out.println("1: Register Student");
            System.out.println("2: Update Student info");
            System.out.println("3: View Student info");
            System.out.println("4: Show all");
            System.out.println("5: Delete Student");
            System.out.println("Q: Go back to startMenu");
            choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    studentDAOImpl.create(student);
                    break;
                case "2":
                    studentDAOImpl.update(student);
                    break;
                case "3":
                    studentDAOImpl.sortByStudent();
                    break;
                case "4":
                    studentDAOImpl.findAll();
                    break;
                case "5":
                    studentDAOImpl.delete(student);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }

    private static void teacherMenu() {
        String choice = " ";
        Teacher teacher = new Teacher();
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl();
        Education education;
        Course course;
        List<Course> courseSet = new ArrayList<>();

        do {
            System.out.println("1: Register Teacher");
            System.out.println("2: Update Teacher info");
            System.out.println("3: View Teacher info");
            System.out.println("4: Show all");
            System.out.println("5: Add Course to Teacher");
            System.out.println("6: Remove Course from Teacher");
            System.out.println("7: Delete Teacher");
            System.out.println("Q: Go back to startMenu");
            choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    teacherDAOImpl.create(teacher);
                    break;
                case "2":
                    teacherDAOImpl.update(teacher);
                    break;
                case "4":
                    teacherDAOImpl.findAll();
                    break;
                case "3":
                    teacherDAOImpl.sortByTeacher();
                    break;
                case "5":
                    teacherDAOImpl.addCourseToTeacher();
                    break;
                case "6":
                    teacherDAOImpl.deleteCourseFromTeacher();
                    break;
                case "7":
                    teacherDAOImpl.delete(teacher);
                    break;
                default:
                    if (!choice.equals("Q"))
                        System.out.println("Unexpected value, please try again");
            }
        } while (!choice.equals("Q"));
    }
}