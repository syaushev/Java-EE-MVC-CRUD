package app.dao;

import app.model.Student;


import java.util.List;


public interface StudentDao {

    void save(Student student);

    void deleteStudent(int id);

    Student findStudentById(int id);

    List<Student> getAllStudents();

}
