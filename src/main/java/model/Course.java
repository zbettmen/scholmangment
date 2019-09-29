package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int courseCounter;
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int courseDuration;
    private List<Student> studentList;


    public Course(int courseId, String courseName, LocalDate startDate, int courseDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.courseDuration = courseDuration;
        this.studentList = new ArrayList<>();
    }

    public Course(String courseName, LocalDate startDate, int courseDuration) {
        this (++courseCounter,courseName,startDate,courseDuration);
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void addStudent (Student student){
        if (!studentList.contains(student)) {
            studentList.add(student);
            System.out.println(student.getName()+" added to "+getCourseName());
        }
    }

    public void removeStudent (int id){
        removeStudent(findById(id));
    }

    public void removeStudent (Student student){
        System.out.println(student.getName()+" removed from "+getCourseName());
        studentList.remove(student);
    }


    // TESTED
    public Student findByEmail (String email){
        for (Student student:studentList) {
            if (student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    // TESTED
    public Student findById (int id){
        for (Student student:studentList) {
            if (student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }
    public void getInfo(){
        System.out.println("\n-----------COURSE--INFO-----------"+
                "\nName: "+getCourseName()+
                "\nID: "+getCourseId()+
                "\nStart date: "+getStartDate()+
                "\nCourse duration: "+getCourseDuration()+" weeks\n"+
                "-----------COURSE--INFO-----------\n");
    }


}
