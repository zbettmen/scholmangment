package se.ecutb.scholm;

import data_access.CourseDaoList;
import model.Course;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class testCourse {
    private Course course;
    private CourseDaoList courseDaoList;
    @Before
    public void setup() {
        course = new Course(1, "Test Course", LocalDate.parse("1991-07-07"), 5);
        courseDaoList = new CourseDaoList();

    }
    @Test
    public void test_save_course(){
        Course expected = course;
        Course actual = courseDaoList.saveCourse(course);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void test_remove_course(){
        courseDaoList.saveCourse(course);
        boolean expected = true;
        Assert.assertEquals(expected, courseDaoList.removeCourse(course));


    }

}
