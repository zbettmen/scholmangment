package se.ecutb.scholm;

import data_access.StudentDaoList;
import model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class testStudent {
    private Student student;
    private StudentDaoList studentDaoList;
    private run running = new run();

    @Before
    public void setUp() {
        student = new Student(1, "Test Student", "test@email.com", "Test Address");
        studentDaoList = new StudentDaoList();
    }

    @Test
    public void testSaveStuden() {
        Student expected = student;
        Student actual = studentDaoList.saveStudent(student);
        Assert.assertEquals(expected, actual);
        actual = studentDaoList.saveStudent(student);
        Assert.assertEquals(null, actual);

    }


    @Test
    public void registerStudent() {
        String name = "riki";
        String email = "riki@hot.com";
        String adress = "riki vagen 29";
        Student student = new Student(name, email, adress);
        studentDaoList.saveStudent(student);

    }
    @Test
    public void delet_and_add_student(){
        String name = "riki";
        String email = "riki@hot.com";
        String adress = "riki vagen 29";
        Student student = new Student(name, email, adress);
        studentDaoList.saveStudent(student);
        Assert.assertEquals(true, studentDaoList.deleteStudent(student));

    }


}



