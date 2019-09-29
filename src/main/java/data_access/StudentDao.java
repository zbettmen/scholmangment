package data_access;

import model.Student;

import java.util.List;


    public interface StudentDao {
        Student saveStudent(Student student);
        Student findByEmail(String email);
        Student findById(int id);
        List<Student> findByName(String name);
        List<Student> findAll();
        boolean deleteStudent (Student student);
    }



