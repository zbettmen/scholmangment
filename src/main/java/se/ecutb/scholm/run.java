package se.ecutb.scholm;

import data_access.CourseDaoList;
import data_access.StudentDaoList;
import model.Course;
import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;

public class run {
    private CourseDaoList courseList = new CourseDaoList();
    private StudentDaoList studentList = new StudentDaoList();
    searchStudent search = new searchStudent();

    int choice;
    boolean run = true;
    input Input = new input();

    public void run() {
        while (run) {

            switch (search.menu()) {
                case 1:
                    crateNewStudenCourse();
                    break;

                case 2:
                    removeStudentsandRegister();
                    break;

                case 3:
                    findCourseStuden();

                case 4:
                    editStudentEditCourse();
                      break;
                case 5:
                    run = false;
                    break;
            }

        }

    }


    public int crateNewStudenCourse() {

        System.out.println("1.Create new student\n" + "2. Course");
        switch (input.getInt()) {
            case 1:
                System.out.print("Enter name: ");
                String name = input.getString();
                System.out.print("Enter email: ");
                String email = input.getString();
                System.out.print("Enter address: ");
                String address = input.getString();
                Student student = new Student(name, email, address);
                studentList.saveStudent(student);
                System.out.println("Student   " + student.getName() + " added  " + student.getEmail() + student.getAddress());
                break;

            case 2:
                System.out.print("Enter course name: ");
                String names = input.getString();
                System.out.print("Enter start date: ");
                LocalDate date = LocalDate.parse(input.getString());
                System.out.print("Enter course duration: ");
                int duration = input.getInt();
                Course course = new Course(names, date, duration);
                courseList.saveCourse(course);
                System.out.println("Course" + course.getCourseName() + "added");
                break;

        }
        return input.getInt();
    }

    public int removeStudentsandRegister() {
        System.out.println("(1) Register/ (2) Remove student from course");
        switch (input.getInt()) {
            case 1:
                for (Course course : courseList.findAll()) {
                    System.out.println(course.getCourseName() + " ID: " + course.getCourseId());

                }
                System.out.println("Enter the email address of the student");
                Student temp = studentList.findByEmail(input.getString());

                try {

                    courseList.findById(input.getInt()).addStudent(temp);

                } catch (InputMismatchException | NullPointerException e) {
                    System.out.println("Email or ID non existent");
                    break;

                }
            case 2:
                for (Course course : courseList.findAll()) {
                    System.out.println(course.getCourseName() + " ID: " + course.getCourseId());
                }
                System.out.println("Enter the email address of the student and the ID");
                Student tempStudent = studentList.findByEmail(input.getString());
                try {
                    courseList.findById(input.getInt()).removeStudent(tempStudent);
                } catch (InputMismatchException | NullPointerException e) {
                    System.out.println("Email or ID non existent");
                    break;

                }
            default:
                System.out.println("Choose betwin 1-2 ");

        }
        return input.getInt();

    }

    public int findCourseStuden() {
        System.out.println("(1)Find student (2) Find course");
        switch (input.getInt()) {

            case 1:
                search.searchStudent();
                if (input.getInt() == 1) {
                    System.out.println("Enter student name");
                    List<Student> tempStudentList = studentList.findByName(input.getString());
                    for (Student student : tempStudentList) {
                        student.getInfo();

                    }


                } else if (input.getInt() == 2) {
                    System.out.println("Enter student ID");
                    try {

                        Student tempStudent = studentList.findById(input.getInt());
                        tempStudent.getInfo();

                    } catch (NullPointerException | InputMismatchException e) {
                        System.out.println("Enter valid ID");
                    }

                } else if (input.getInt() == 3) {
                    System.out.println("Enter student Email");
                    try {
                        Student tempStudent = studentList.findByEmail(input.getString());
                        tempStudent.getInfo();
                    } catch (NullPointerException e) {
                        System.out.println("Enter valid Email");
                    }

                } else if (input.getInt() == 4) {
                    List<Student> tempStudentList = studentList.findAll();
                    for (Student student : tempStudentList) {
                        student.getInfo();

                    }break;

                }
            case 2:
                search.searchCourse();
                input.getInt();
                if (input.getInt() == 1) {
                    System.out.println("Enter course ID");
                    try {
                        Course tempCourse = courseList.findById(input.getInt());
                        tempCourse.getInfo();

                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Enter valid ID");
                    }

                } else if (input.getInt() == 2) {

                    System.out.println("Enter course name");
                    List<Course> tempList = courseList.findByName(input.getString());
                    for (Course course : tempList) {
                        course.getInfo();

                    }


                } else if (input.getInt() == 3) {

                    System.out.println("Enter course name");
                    try {
                        List<Course> tempList = courseList.findByDate(LocalDate.parse(input.getString()));
                        for (Course course : tempList) {
                            course.getInfo();
                        }
                    } catch (NullPointerException | DateTimeParseException e) {
                        System.out.println("Enter valid date (YYYY-MM-DD)");
                    }
                } else if (input.getInt() == 4) {
                    List<Course> tempList = courseList.findAll();
                    for (Course course : tempList) {
                        course.getInfo();

                    }break;
                }

        }
        return input.getInt();
    }
    public int editStudentEditCourse() {
        System.out.println("(1) Edit student\n(2) Edit course");
        switch (input.getInt()) {
            case 1:
                System.out.println("Enter email of student you wish to edit");
           try  {
              Student student = studentList.findByEmail(input.getString());
              System.out.println(student.getName() + ("\n(1) Edit name: \n(2) Edit email: \n(3) Edit address"));
              if (input.getInt() == 1) {
                  System.out.println("Enter new name");
                  student.setName(input.getString());
                  System.out.println("Good! changed");
              } else if (input.getInt() == 2) {
                  System.out.println("enter new email");
                  {
                      student.setEmail(input.getString());

                  }

              } else if (input.getInt() == 3) {
                  System.out.println("Enter new adress");
                  student.setAddress(input.getString());

              }

           }catch (NullPointerException e){
               System.out.println("Enter betwin 1-2");
           }   break;

            case 2:    //Todo try catch
                System.out.println("Enter course you wish to edit");
                Course course = courseList.findById(input.getInt());
                System.out.println(course.getCourseName() + "\n(1) Edit name: \n(2) Edit start date: \n(3) Edit course duration:");
                input.getString();
                if(input.getInt() == 1){
                    System.out.println("enter a new name");
                    course.setCourseName(input.getString());
                    

                }
                else if (input.getInt() == 2){
                    System.out.println("Enter a new start date ");
                    course.setStartDate(LocalDate.parse(input.getString()));

                }else if(input.getInt() == 3){
                    System.out.println("Enter new course duration");
                    course.setCourseDuration(input.getInt());

                }
                  break;

        }
        return input.getInt();
    }




}




