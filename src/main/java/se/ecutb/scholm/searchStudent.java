package se.ecutb.scholm;

public class searchStudent {

    public int searchStudent() {
        System.out.println("(1) Find student by name\n" +
                "(2) Find student by ID\n" +
                "(3) Find student by email\n" +
                "(4) Get a list of all students");
        return input.getInt();

    }

    public int searchCourse() {
        System.out.println("(1) Find course by ID\n" +
                "(2) Find course by name\n" +
                "(3) Find course by start date\n" +
                "(4) Get a list of all courses");
        return input.getInt();

    }


    public int menu() {

        System.out.println("(1) Create new student/course\n" +
                "(2) Register/Remove student from course\n" +
                "(3) Find specific student/course\n" +
                "(4) Edit student/course\n" +
                "(5) Quit");
        System.out.println("make your choice ");
        return input.getInt();


    }
}